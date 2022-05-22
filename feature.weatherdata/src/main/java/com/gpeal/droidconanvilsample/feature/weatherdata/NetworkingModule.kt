package com.gpeal.droidconanvilsample.feature.weatherdata

import com.gpeal.droidconanvilsample.lib.daggerscopes.WeatherScope
import com.gpeal.droidconanvilsample.lib.daggerscopes.SingleIn
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

/**
 * You almost never need to create a Dagger module.
 * One of the rare cases is if you want to hand-initialize the object.
 */
@Module
@ContributesTo(WeatherScope::class)
object NetworkingModule {
    @Provides
    @SingleIn(WeatherScope::class)
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @SingleIn(WeatherScope::class)
    fun providesRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://weatherdbi.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}