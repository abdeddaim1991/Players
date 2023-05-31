// Network Service: an Interface that handles the external API calls
package com.fdj.players.network

import com.fdj.players.viewModels.SportsDBApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/50130162/"
    private const val API_KEY = "50130162"

    fun createApiService(): SportsDBApi {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val modifiedRequest = originalRequest.newBuilder()
                    .header("Key", API_KEY)
                    .build()
                chain.proceed(modifiedRequest)
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(SportsDBApi::class.java)
    }
}