package com.fdj.players.viewModels.leagues
import com.fdj.players.models.League
import org.junit.Assert.assertEquals
import org.junit.Test
class LeagueResponseTest {

    @Test
    fun leagueResponse_shouldHaveCorrectLeaguesList() {
        // Create a list of League objects
        val leagueList = listOf(
            League(
                idLeague = "4328",
                strLeague = "English Premier League",
                strSport = "Soccer",
                strLeagueAlternate = "Premier League, EPL"
            ),
            League(
                idLeague = "4329",
                strLeague = "English League Championship",
                strSport = "Soccer",
                strLeagueAlternate = "Championship"
            )
        )

        // Create a LeagueResponse object with the league list
        val leagueResponse = LeagueResponse(leagueList)

        // Assert that the leagues list has the correct value
        assertEquals(leagueList, leagueResponse.leagues)
    }
}