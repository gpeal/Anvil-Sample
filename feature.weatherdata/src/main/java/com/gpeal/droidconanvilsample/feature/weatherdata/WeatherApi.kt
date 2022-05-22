package com.gpeal.droidconanvilsample.feature.weatherdata

import com.gpeal.droidconanvilsample.lib.daggerscopes.ContributesApi
import com.squareup.moshi.Json
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * This retrofit API is automatically contributed to the application graph via this annotation.
 * Normally, you would need to create a Dagger module and provide this by hand.
 * Refer to the :anvilcodegen module for how this works.
 */
@ContributesApi
interface WeatherApi {
    @GET("data/weather/{query}")
    suspend fun getWeather(@Path("query") query: String): WeatherResponse
}

data class WeatherResponse(
    @Json(name = "next_days") val nextDays: List<NextDay>,
)

data class NextDay(
    @Json(name = "max_temp") val maxTemp: MaxTemp,
)

data class MaxTemp(val f: Int)