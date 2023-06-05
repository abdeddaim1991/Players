package com.fdj.players.network

import org.junit.Assert.assertNotNull
import org.junit.Test


class NetworkServiceTest {

    @Test
    fun createApiService_shouldReturnNonNullService() {
        // Create the NetworkService instance
        val networkService = NetworkService

        // Call the createApiService() function
        val apiService = networkService.createApiService()

        // Assert that the returned apiService is not null
        assertNotNull(apiService)
    }
}