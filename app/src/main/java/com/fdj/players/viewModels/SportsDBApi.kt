//Interface that makes network requests to retrieve data related to leagues and teams
package com.fdj.players.viewModels

import com.fdj.players.viewModels.leagues.LeagueResponse
import com.fdj.players.viewModels.teams.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportsDBApi {
    // API endpoint to get all leagues
    @GET("all_leagues.php")
    suspend fun getAllLeagues(): Response<LeagueResponse>

    // API endpoint to search teams by league
    @GET("search_all_teams.php")
    suspend fun searchTeamsByLeague(@Query("l") league: String): Response<TeamResponse>
}