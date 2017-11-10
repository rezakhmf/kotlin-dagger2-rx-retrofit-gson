package com.reza.foxsport.match.presenter

import com.reza.foxsport.Utils.API
import com.reza.foxsport.match.model.Matches
import com.reza.foxsport.match.view.IMatchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


/**
 * Created by reza on 5/11/17.
 */
class MatchPresenter(matchesEndPoint: IMatchesEndPoint) : IMatchPresenter {


    //@Inject
   private var view: IMatchView? = null
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
   // @Inject
    var matchesEndpoint: IMatchesEndPoint = matchesEndPoint

    override fun displayMatches() {

        val disposableMatches: Disposable = matchesEndpoint?.fetchMatches(API.MATCHES_URL.value)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({
                    if (isViewAttached()) {
                        view?.loadingStarted()
                    }
                }).subscribeBy(
                    onNext = {
                        matches -> onMatchesResult(matches)
                    },
                    onError = {
                        error -> onMatchesFetchError(error)
                    },
                    onComplete = {}
        )

        disposableMatches?.let { compositeDisposable?.add(it) }
    }

    override fun setView(view: IMatchView) {
        this.view = view
    }

    override fun destroy() {
        view = null
        compositeDisposable?.clear()
    }

    private fun onMatchesResult(matches: Matches) {

        val _matches = matches?.getMatches()

        if (isViewAttached()) {
            if (_matches != null) {
                view?.showMatches(_matches)
            }
        }
    }

    private fun onMatchesFetchError(throwable: Throwable) {
        if (isViewAttached()) {
            view?.loadingFailed(throwable.message)
        } else {
            // do nothing
        }
    }

    private fun isViewAttached(): Boolean {
        return view != null
    }
}