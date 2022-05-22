package com.gpeal.droidconanvilsample.feature.weatherui

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.gpeal.droidconanvilsample.lib.daggerscopes.utils.DaggerComponentOwner
import com.gpeal.droidconanvilsample.lib.daggerscopes.utils.bindings
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherRepository
import javax.inject.Inject

class WeatherViewModel(application: Application) : AndroidViewModel(application), DaggerComponentOwner {

    override val daggerComponent = application.bindings<WeatherComponent.ParentBindings>().weatherComponentBuilder().create()

    @Inject
    lateinit var weatherRepository: WeatherRepository

    init {
        bindings<WeatherBindings>().inject(this)
    }
}

class WeatherFragmentWithViewModel : Fragment(R.layout.weather_fragment) {
    private val viewModel: WeatherViewModel by viewModels()
}