package com.reza.foxsport.match.model

/**
 * Created by reza on 5/11/17.
 */
import java.util.HashMap
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TopPlayer {

    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("position")
    @Expose
    private var position: String? = null
    @SerializedName("full_name")
    @Expose
    private var fullName: String? = null
    @SerializedName("short_name")
    @Expose
    private var shortName: String? = null
    @SerializedName("stat_value")
    @Expose
    private var statValue: Int? = null
    @SerializedName("jumper_number")
    @Expose
    private var jumperNumber: Int? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getPosition(): String? {
        return position
    }

    fun setPosition(position: String) {
        this.position = position
    }

    fun getFullName(): String? {
        return fullName
    }

    fun setFullName(fullName: String) {
        this.fullName = fullName
    }

    fun getShortName(): String? {
        return shortName
    }

    fun setShortName(shortName: String) {
        this.shortName = shortName
    }

    fun getStatValue(): Int? {
        return statValue
    }

    fun setStatValue(statValue: Int?) {
        this.statValue = statValue
    }

    fun getJumperNumber(): Int? {
        return jumperNumber
    }

    fun setJumperNumber(jumperNumber: Int?) {
        this.jumperNumber = jumperNumber
    }
}