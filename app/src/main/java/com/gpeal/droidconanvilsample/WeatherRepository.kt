package com.gpeal.droidconanvilsample

import com.gpeal.droidconanvilsample.utils.SingleIn
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.ContributesMultibinding
import dagger.multibindings.StringKey
import javax.inject.Inject

// This could live in a shared library module.
interface WeatherDataSource {
    suspend fun getForecast(): List<Int>
}

// This could live in a shared library module.
interface WeatherRepository : WeatherDataSource

// This could live in a leaf impl/feature module.
@ContributesMultibinding(WeatherScope::class)
@StringKey("WeatherChannel")
class WeatherChannelDataSource @Inject constructor() : WeatherDataSource {
    override suspend fun getForecast(): List<Int> {
        return listOf(72, 70, 75, 78, 74, 78, 79)
    }
}

// This could live in a leaf impl/feature module.
@ContributesMultibinding(WeatherScope::class)
@StringKey("WeatherUnderground")
class WeatherUndergroundDataSource @Inject constructor(): WeatherDataSource {
    override suspend fun getForecast(): List<Int> {
        return listOf(73, 71, 76, 77, 75, 79, 89)
    }
}

// This could live in a leaf impl/feature module.
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