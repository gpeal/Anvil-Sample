package com.gpeal.droidconanvilsample.app

import com.gpeal.droidconanvilsample.feature.weatherdata.WeatherRepositoryImpl
import com.gpeal.droidconanvilsample.lib.daggerscopes.WeatherScope
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherRepository
import com.squareup.anvil.annotations.ContributesBinding

@ContributesBinding(WeatherScope::class, replaces = [WeatherRepositoryImpl::class])
object TestWeatherRepository : WeatherRepository {
    override suspend fun getForecast(): List<Int> = listOf(1, 2, 3, 4, 5)
}