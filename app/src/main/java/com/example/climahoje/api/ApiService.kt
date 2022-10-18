package com.example.climahoje.api

import Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast?")
    suspend fun getWeatherData(
        @Query("q") q : String = city,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = "metric"
    ): Response<Root>

    companion object {
        val API_KEY = "77cc11404020d9911e38f90435b7745b"
        var city = "São Paulo"
    }
}
