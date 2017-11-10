package com.reza.foxsport.match.model






/**
 * Created by reza on 5/11/17.
 */
//@JsonFormat(shape= JsonFormat.Shape.ARRAY)
class Matches {

    private var matches: List<Match>? = null

    fun getMatches(): List<Match>? {
        return matches
    }

    fun setMatches(matches: List<Match>) {
        this.matches = matches
    }

}
