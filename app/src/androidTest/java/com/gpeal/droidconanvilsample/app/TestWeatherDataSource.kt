package com.gpeal.droidconanvilsample.app

import com.gpeal.droidconanvilsample.feature.weatherdata.WeatherDbDataSource
import com.gpeal.droidconanvilsample.lib.daggerscopes.WeatherScope
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherDataSource
import com.squareup.anvil.annotations.ContributesMultibinding
import dagger.multibindings.StringKey

@StringKey("WeatherDb")
@ContributesMultibinding(WeatherScope::class, replaces = [WeatherDbDataSource::class])
object TestWeatherDataSource : WeatherDataSource {
    override suspend fun getForecast(): List<Int> = listOf(1, 2, 3, 4, 5)
}
