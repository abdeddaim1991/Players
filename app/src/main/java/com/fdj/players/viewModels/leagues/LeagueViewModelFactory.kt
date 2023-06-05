// custom league view model
package com.fdj.players.viewModels.leagues
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LeagueViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeagueViewModel::class.java)) {
            return LeagueViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}