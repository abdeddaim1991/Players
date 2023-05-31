// class that contain all the logic
package com.fdj.players.viewModels.leagues
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fdj.players.R
import com.fdj.players.models.League
import com.fdj.players.models.Team
import com.fdj.players.network.NetworkService
import com.fdj.players.viewModels.SportsDBApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LeagueViewModel(private val context: Context) : ViewModel() {
    var sportsDBApi: SportsDBApi = NetworkService.createApiService()

    val leagues = mutableStateListOf<League>()
    val teamsList = mutableStateListOf<Team>()
    var errorMessage: String = ""
    var isLoading by mutableStateOf(false)
        private set

    init {
        fetchLeagues()
    }

    fun fetchLeagues() {
        isLoading = true
        viewModelScope.launch {
            try {
                // Make an API call to get all leagues
                val leaguesResponse = sportsDBApi.getAllLeagues()

                withContext(Dispatchers.Main) {
                    // Update the leagues list if the API call is successful
                    if (leaguesResponse.isSuccessful) {
                        leagues.addAll(leaguesResponse.body()?.leagues ?: emptyList())
                    } else {
                        errorMessage = context.getString(R.string.error_api)
                    }
                }
            } catch (e: Exception) {
                errorMessage = context.getString(R.string.error_api)
            } finally {
                isLoading = false // Set isLoading to false after the API call completes
            }
        }
    }

    fun onItemClick(league: League) {
        if (isNetworkConnected()) {
            isLoading = true
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    // Make an API call to search teams by league
                    val responseTeamApi = sportsDBApi.searchTeamsByLeague(league.strLeague)

                    if (responseTeamApi.isSuccessful) {
                        val teamResponse = responseTeamApi.body()
                        teamsList.clear()
                        teamResponse?.teams?.let { teams ->
                            val sortedTeams = teams.sortedByDescending { it.strTeam }
                            val filteredTeams = sortedTeams.filterIndexed { index, _ -> index % 2 == 0 }
                            teamsList.addAll(filteredTeams)
                        }
                    } else {
                        // Handle API error
                        errorMessage = context.getString(R.string.error_api)
                    }
                } catch (e: Exception) {
                    // Handle network or API exception
                    errorMessage = context.getString(R.string.error_api)
                } finally {
                    isLoading = false // Set isLoading to false after the API call completes
                }
            }
        } else {
            // Handle no internet connection
            errorMessage = context.getString(R.string.error_network)
        }
    }

    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val networkCapabilities = connectivityManager?.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}