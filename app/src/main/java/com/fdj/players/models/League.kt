// League Model
package com.fdj.players.models

data class League(
    val idLeague: String,                 // Unique identifier for the league
    val strLeague: String,                // Name of the league
    val strSport: String,                 // Sport associated with the league
    val strLeagueAlternate: String        // Alternate name or alias for the league
)