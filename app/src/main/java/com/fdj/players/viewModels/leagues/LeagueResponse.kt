//Data class that represents the response received from the API when searching for leagues
package com.fdj.players.viewModels.leagues

import com.fdj.players.models.League

data class LeagueResponse(val leagues: List<League>)
