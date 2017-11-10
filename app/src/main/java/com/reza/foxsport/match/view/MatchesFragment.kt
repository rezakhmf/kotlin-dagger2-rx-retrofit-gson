package com.reza.foxsport.match.view

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.reza.foxsport.App
import com.reza.foxsport.R
import com.reza.foxsport.match.model.Match
import com.reza.foxsport.match.module.MatchesModule
import com.reza.foxsport.match.presenter.IMatchPresenter
import kotlinx.android.synthetic.main.fragment_matches.*
import javax.inject.Inject

/**
 * Created by reza on 5/11/17.
 */
class MatchesFragment : Fragment(), IMatchView, MatchesAdapter.Callback {

    @Inject
    lateinit var matchesPresenter: IMatchPresenter
    @Inject
    lateinit var adapter: MatchesAdapter

    val component by lazy {
        App.get(activity).appComponent.plus(MatchesModule(this))
    }

    private var matches = mutableListOf<Match>()
    private var callback: Callback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as Callback
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        component.inject(this)
        matchesPresenter?.setView(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater?.inflate(R.layout.fragment_matches, container, false)
        rootView?.let { initLayoutReferences(it) }!!
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchesPresenter?.displayMatches()
    }

    private fun initLayoutReferences(rootView: View) {

        val rvMatches = rootView.findViewById<View>(R.id.rv_matches) as RecyclerView
        rvMatches.setHasFixedSize(true)

        rvMatches.layoutManager = LinearLayoutManager(activity)
        //rvMatches.addItemDecoration(SimpleDividerItemDecoration(rootView.context))
            this.adapter?.updateMatches(this.matches)
            rvMatches.setAdapter(this.adapter)
    }

    override fun showMatches(matches: List<Match>) {
        this.matches?.clear()
        this.matches?.addAll(matches)
        this.adapter?.notifyDataSetChanged()
    }

    override fun loadingStarted() {
        Toast.makeText(activity, "loading matches", Toast.LENGTH_SHORT).show()
    }

    override fun loadingFailed(errorMessage: String?) {
        Toast.makeText(activity, "failed loading matches" + errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onMatchClicked(match: Match) {
        callback?.onMatchClicked(match)
        Toast.makeText(activity, "Sorry have no time to implement players details", Toast.LENGTH_LONG).show()
    }

    public interface Callback {
        fun onMatchesLoaded(match: Match)
        fun onMatchClicked(match: Match)
    }
}

