package com.reza.foxsport.match.model

/**
 * Created by reza on 5/11/17.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.HashMap


class TeamB {
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("code")
    @Expose
    private var code: String? = null
    @SerializedName("short_name")
    @Expose
    private var shortName: String? = null
    @SerializedName("top_players")
    @Expose
    private var topPlayers: List<TopPlayer>? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getCode(): String? {
        return code
    }

    fun setCode(code: String) {
        this.code = code
    }

    fun getShortName(): String? {
        return shortName
    }

    fun setShortName(shortName: String) {
        this.shortName = shortName
    }

    fun getTopPlayers(): List<TopPlayer>? {
        return topPlayers
    }

    fun setTopPlayers(topPlayers: List<TopPlayer>) {
        this.topPlayers = topPlayers
    }

}