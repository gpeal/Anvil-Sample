package com.gpeal.droidconanvilsample.lib.weatherdata

interface WeatherDataSource {
    suspend fun getForecast(): List<Int>
}