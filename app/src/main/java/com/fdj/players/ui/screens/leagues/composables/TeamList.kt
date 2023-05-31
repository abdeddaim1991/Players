//Composable function to render a list of teams
package com.fdj.players.ui.screens.leagues.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fdj.players.models.Team

class TeamList {

    /**
     * Composable function to render a list of teams.
     *
     * @param teams The list of teams to display.
     */
    @Composable
    fun content(teams: List<Team>) {
        LazyColumn(Modifier.fillMaxWidth()) {
            val teamsPerLine = 2
            val lines = teams.chunked(teamsPerLine)
            items(lines.size) { index ->
                Box(Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        content = {
                            lines[index].forEach { team ->
                                // Display team logo if the strTeamLogo field is not empty
                                TeamLogo().notEmptyLogo(
                                    logoUrl = team.strTeamBadge,
                                    width = 180.dp,
                                    height = 100.dp
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}