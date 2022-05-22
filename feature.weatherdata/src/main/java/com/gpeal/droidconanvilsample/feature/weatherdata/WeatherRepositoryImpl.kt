package com.gpeal.droidconanvilsample.feature.weatherdata

import android.util.Log
import com.gpeal.droidconanvilsample.lib.daggerscopes.WeatherScope
import com.gpeal.droidconanvilsample.lib.daggerscopes.SingleIn
import com.gpeal.droidconanvilsample.lib.userprefs.UserPrefs
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherDataSource
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherRepository
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@SingleIn(WeatherScope::class)
@ContributesBinding(WeatherScope::class)
class WeatherRepositoryImpl @Inject constructor(
    private val userPrefs: UserPrefs,
    private val dataSources: Map<String, @JvmSuppressWildcards WeatherDataSource>,
) : WeatherRepository {
    override suspend fun getForecast(): List<Int> {
        return dataSources[userPrefs.dataSource]?.getForecast() ?: error("Unknown data source ${userPrefs.dataSource}!")
    }
}