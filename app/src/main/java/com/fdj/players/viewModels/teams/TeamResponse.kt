//Data class that represents the response received from the API when searching for teams
package com.fdj.players.viewModels.teams

import com.fdj.players.models.Team

data class TeamResponse(val teams: List<Team>)
