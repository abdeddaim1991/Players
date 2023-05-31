// test class for leagueViewModel
package com.fdj.players.viewModels.leagues

import android.content.Context
import com.fdj.players.R
import com.fdj.players.models.League
import com.fdj.players.models.Team
import com.fdj.players.viewModels.SportsDBApi
import com.fdj.players.viewModels.teams.TeamResponse
import io.mockk.coEvery
import retrofit2.Response
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock


@ExperimentalCoroutinesApi
class LeagueViewModelTest {

    @Mock
    private lateinit var context: Context

    private lateinit var viewModel: LeagueViewModel
    private lateinit var testDispatcher: TestCoroutineDispatcher
    private lateinit var sportsDBApi: SportsDBApi
    @Before
    fun setup() {
        // Create a test dispatcher
        testDispatcher = TestCoroutineDispatcher()

        // Set the main dispatcher to the test dispatcher
        Dispatchers.setMain(testDispatcher)
        context = mockk(relaxed = true)
        sportsDBApi = mockk(relaxed = true)
        viewModel = LeagueViewModel(context)
        viewModel.sportsDBApi = sportsDBApi
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun testFetchLeagues() = testDispatcher.runBlockingTest {
        // Create a mock response
        val mockLeagues = listOf(League("4335", "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga"))
        var result = LeagueResponse(mockLeagues)
        // Stub the API call
        coEvery { sportsDBApi.getAllLeagues() } returns Response.success(result)

        // Call the function under test
        viewModel.fetchLeagues()


        // Advance the coroutine to execute suspended functions
        testDispatcher.advanceUntilIdle()

        val league = viewModel.leagues.first()
        assertEquals("4328", league.idLeague) // Verify the league ID
        assertEquals("English Premier League", league.strLeague) // Verify the league name
        assertEquals("Soccer", league.strSport) // Verify the sport type
        assertEquals("Premier League, EPL", league.strLeagueAlternate) // Verify the alternate league name

        // Verify that the error message is empty
        assertEquals("", viewModel.errorMessage)
    }



    @Test
    fun testOnItemClick_withInternetConnection_failedApiCall() = runBlockingTest {
        // Mock data
        val mockLeague = League("4335", "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga")
        val responseTeamApi = Response.error<TeamResponse>(400, ResponseBody.create(null, "API error"))

        // Mock API call
        coEvery { sportsDBApi.searchTeamsByLeague(mockLeague.strLeague) } returns responseTeamApi

        // Call the function under test
        viewModel.onItemClick(mockLeague)

        // Verify the state after failed API call
        assertEquals(context.getString(R.string.error_api), viewModel.errorMessage)
        assertEquals(emptyList<Team>(), viewModel.teamsList)
    }




    @Test
    fun testOnItemClick_noInternetConnection() = runBlockingTest {
        // Mock data
        val mockLeague = League("4335", "Spanish La Liga", "Soccer", "LaLiga Santander, La Liga")

        // Call the function under test
        viewModel.onItemClick(mockLeague)

        // Verify the state when there is no internet connection
        assertEquals(context.getString(R.string.error_network), viewModel.errorMessage)
        assertEquals(emptyList<Team>(), viewModel.teamsList)
    }



}