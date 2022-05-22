package com.gpeal.droidconanvilsample.feature.weatherdata

import com.gpeal.droidconanvilsample.lib.daggerscopes.WeatherScope
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherDataSource
import com.squareup.anvil.annotations.ContributesMultibinding
import dagger.multibindings.StringKey
import javax.inject.Inject

@StringKey("WeatherChannel")
@ContributesMultibinding(WeatherScope::class)
class WeatherDataSources @Inject constructor() : WeatherDataSource {
    override suspend fun getForecast(): List<Int> {
        return listOf(72, 70, 75, 78, 74, 78, 79)
    }
}

@StringKey("WeatherUnderground")
@ContributesMultibinding(WeatherScope::class)
class WeatherUndergroundDataSource @Inject constructor(): WeatherDataSource {
    override suspend fun getForecast(): List<Int> {
        return listOf(73, 71, 76, 77, 75, 79, 89)
    }
}