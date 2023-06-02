package com.fdj.players.models

import org.junit.Assert.assertEquals
import org.junit.Test

class LeagueTest {

    @Test
    fun testLeagueProperties() {
        // Create a league object
        val league = League(
            idLeague = "123",
            strLeague = "Premier League",
            strSport = "Football",
            strLeagueAlternate = "EPL"
        )

        // Verify the properties of the league object
        assertEquals("123", league.idLeague)
        assertEquals("Premier League", league.strLeague)
        assertEquals("Football", league.strSport)
        assertEquals("EPL", league.strLeagueAlternate)
    }
}