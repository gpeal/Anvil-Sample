package com.gpeal.droidconanvilsample.feature.weatherui

import com.gpeal.droidconanvilsample.lib.daggerscopes.WeatherScope
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(WeatherScope::class)
interface WeatherBindings {
    fun inject(fragment: WeatherFragmentSimple)
    fun inject(vm: WeatherViewModel)
}