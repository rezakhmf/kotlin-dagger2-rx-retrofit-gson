package com.reza.foxsport.match.presenter

import com.reza.foxsport.match.model.Match
import com.reza.foxsport.match.model.Matches
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by reza on 5/11/17.
 */
interface IMatchesEndPoint {

    @GET
    fun fetchMatches(@Url url: String): Flowable<Matches>
}