// Class that handles the rendring of interface's components
package com.fdj.players.ui.screens.leagues.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fdj.players.ui.screens.leagues.isNetworkConnected
import com.fdj.players.viewModels.leagues.LeagueViewModel

class SportsDBApp {

    /**
     * Composable function to render the content of the SportsDB app.
     *
     * @param viewModel The view model containing the data and logic for the app.
     */
    @Composable
    fun content(viewModel: LeagueViewModel) {
        val leagues = viewModel.leagues
        val errorMessage = viewModel.errorMessage
        val isLoading = viewModel.isLoading

        val networkConnected = viewModel.isNetworkConnected() && isNetworkConnected.value

        Surface(color = MaterialTheme.colors.background) {
            if (isLoading) {
                // Show a loading indicator when data is being loaded
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                if ((errorMessage != null) && (errorMessage.isNotEmpty())) {
                    // Show a Snackbar with an error message if there is an error
                    Snackbar(
                        modifier = Modifier.padding(16.dp),
                    ) {
                        Text(text = errorMessage)
                    }
                } else {
                    Column {
                        if (!networkConnected) {
                            // Display a message when there is no internet connection
                            Text(
                                text = "No internet connection",
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.h6
                            )
                        } else {
                            // Display the autocomplete text field when network is available
                            AutoCompleteField().content(leagues, onItemClick = { league ->
                                viewModel.onItemClick(league)
                            })
                        }
                        // Display the list of teams
                        if (viewModel.teamsList.isNotEmpty()) {
                            TeamList().content(teams = viewModel.teamsList)
                        }
                    }
                }
            }
        }
    }
}