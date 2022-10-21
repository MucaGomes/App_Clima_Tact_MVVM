package com.example.climahoje.repository

import Root
import com.example.climahoje.api.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getWeatherData(): Response<Root>{
        return RetrofitInstance.api.getWeatherData()
    }

    suspend fun getWeatherWeekData(): Root {
        return  RetrofitInstance.api.getWeatherWeekData()
    }

}