package com.reza.foxsport.match.view

import android.app.Fragment
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import com.reza.foxsport.R
import com.reza.foxsport.match.model.Match
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by reza on 6/11/17.
 */
class MatchesActivity : AppCompatActivity(), MatchesFragment.Callback {
    val MATCHES_FRAGMENT = "MatchesFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fragmentManager.beginTransaction()
                .replace(R.id.matches_container, MatchesFragment(), MATCHES_FRAGMENT)
                .addToBackStack(MATCHES_FRAGMENT)
                .commit()
    }

    override fun onMatchesLoaded(match: Match) {

    }

    override fun onMatchClicked(match: Match) {
        loadMatchDetailsFragment(match)
    }

    private fun loadMatchDetailsFragment(match: Match) {

    }
}