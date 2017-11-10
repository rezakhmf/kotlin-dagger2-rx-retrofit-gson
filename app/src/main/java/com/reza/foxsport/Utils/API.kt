package com.reza.foxsport.Utils

/**
 * Created by reza on 5/11/17.
 */
enum class API(val value: String) {
    KEY(""),
    TIMEOUT_IN_MS("30000"),
    BASE_URL("https://statsapi.foxsports.com.au/3.0/api/sports/"),
    MATCHES_URL("league/matches/NRL20172101/topplayerstats.json;type=fantasy_points;type=tackles;type=runs;type=run_metres?limit=5&userkey=A00239D3-45F6-4A0A-810C-54A347F144C2"),
    PLAYER_PIC_URL("http://media.foxsports.com.au/match-centre/includes/images/headshots/landscape/nrl/@playerId.jpg")
}