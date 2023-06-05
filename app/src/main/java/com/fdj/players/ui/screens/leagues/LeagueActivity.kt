// The main screen
package com.fdj.players.ui.screens.leagues
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModelProvider
import com.fdj.players.viewModels.leagues.LeagueViewModel
import com.fdj.players.ui.screens.leagues.composables.SportsDBApp
import com.fdj.players.viewModels.leagues.LeagueViewModelFactory

// Mutable state to track network connectivity
val isNetworkConnected = mutableStateOf(false)

class LeagueActivity : ComponentActivity() {
    lateinit var leagueViewModel: LeagueViewModel
    lateinit var connectivityManager: ConnectivityManager
    lateinit var leagueViewModelFactory: LeagueViewModelFactory

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        leagueViewModelFactory = LeagueViewModelFactory(this)
        leagueViewModel = ViewModelProvider(this, leagueViewModelFactory).get(LeagueViewModel::class.java)
        connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        setContent {
            SportsDBApp().content(leagueViewModel)
        }
    }

    public override fun onResume() {
        super.onResume()
        // Register network callback to track network connectivity changes
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    public override fun onPause() {
        super.onPause()
        // Unregister network callback when the activity is paused
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            // Network is available
            isNetworkConnected.value = true
        }

        override fun onLost(network: Network) {
            // Network is lost
            isNetworkConnected.value = false
        }
    }
}