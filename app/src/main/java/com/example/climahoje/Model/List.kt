package com.example.climahoje.Model

import com.google.gson.annotations.SerializedName

data class List(
    val dt: Long,
    val main: Main,
    val weather: kotlin.collections.List<Weather>,
    val visibility: Long,
    val pop: Double,
    val sys: Sys,
    @SerializedName("dt_txt")
    val dtTxt: String,
)