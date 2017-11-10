package com.reza.foxsport.match.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by reza on 5/11/17.
 */


class Match {
    @SerializedName("match_id")
    @Expose
    private var matchId: String? = null
    @SerializedName("team_A")
    @Expose
    private var teamA: TeamA? = null
    @SerializedName("team_B")
    @Expose
    private var teamB: TeamB? = null
    @SerializedName("stat_type")
    @Expose
    private var statType: String? = null

    fun getMatchId(): String? {
        return matchId
    }

    fun setMatchId(matchId: String) {
        this.matchId = matchId
    }

    fun getTeamA(): TeamA? {
        return teamA
    }

    fun setTeamA(teamA: TeamA) {
        this.teamA = teamA
    }

    fun getTeamB(): TeamB? {
        return teamB
    }

    fun setTeamB(teamB: TeamB) {
        this.teamB = teamB
    }

    fun getStatType(): String? {
        return statType
    }

    fun setStatType(statType: String) {
        this.statType = statType
    }
}