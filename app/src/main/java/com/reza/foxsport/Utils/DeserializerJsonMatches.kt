package com.reza.foxsport.Utils

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import com.google.gson.Gson
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.reza.foxsport.match.model.Match
import com.reza.foxsport.match.model.Matches
import io.reactivex.Observable
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by reza on 8/11/17.
 */
class DeserializerJsonMatches<T> : JsonDeserializer<Matches> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Matches {

        val matches = Matches()

                Observable.just(json.toString())
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map ({ elements ->
                             Gson().fromJson(elements, arrayOf(Match())::class.java)
                             })
                        .flatMap({
                            jsonObjects -> Observable.fromArray(jsonObjects)
                        })
                        .blockingSubscribe({
                            listOfMatches -> matches.setMatches(listOfMatches.toList())
                        })

        return matches
    }
}