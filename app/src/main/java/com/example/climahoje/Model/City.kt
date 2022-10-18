package com.example.climahoje.Model

data class City(
    val id: Long,
    val name: String,
    val country: String,
    val population: Long,
    val timezone: Long,
    val sunrise: Long,
    val sunset: Long,
)