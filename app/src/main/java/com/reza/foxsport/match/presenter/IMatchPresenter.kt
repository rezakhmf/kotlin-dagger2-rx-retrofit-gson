package com.reza.foxsport.match.presenter

import com.reza.foxsport.match.view.IMatchView

/**
 * Created by reza on 5/11/17.
 */
interface IMatchPresenter {

    fun displayMatches()

    fun setView(view: IMatchView)

    fun destroy()
}