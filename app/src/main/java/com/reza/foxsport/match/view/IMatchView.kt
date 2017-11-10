package com.reza.foxsport.match.view

import com.reza.foxsport.match.model.Match

/**
 * Created by reza on 5/11/17.
 */
interface IMatchView {

    fun showMatches(matches: List<Match>)

    fun loadingStarted()

    fun loadingFailed(errorMessage: String?)

    fun onMatchClicked(match: Match)
}