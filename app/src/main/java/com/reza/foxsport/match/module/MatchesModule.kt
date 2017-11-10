package com.reza.foxsport.match.module

import com.reza.foxsport.match.presenter.IMatchPresenter
import com.reza.foxsport.match.presenter.IMatchesEndPoint
import com.reza.foxsport.match.presenter.MatchPresenter
import com.reza.foxsport.match.view.MatchesAdapter
import com.reza.foxsport.match.view.MatchesFragment
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by reza on 6/11/17.
 */
@Module
class MatchesModule(val fragment: MatchesFragment) {

    @Provides
    @FragmentScope
    fun provideMatchesFragment(): MatchesFragment {
        return fragment
    }

    @Provides
    @FragmentScope
    fun provideMatchesPresenter(matchesEndPoint: IMatchesEndPoint): IMatchPresenter {
        return MatchPresenter(matchesEndPoint)
    }

    @Provides
    @FragmentScope
    fun provideMatchesEndpoint(retrofit: Retrofit): IMatchesEndPoint {
        return retrofit.create(IMatchesEndPoint::class.java)
    }

    @Provides
    @FragmentScope
    fun provideMatchesAdaptor(): MatchesAdapter {
        return MatchesAdapter(fragment)
    }

}