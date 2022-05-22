package com.gpeal.droidconanvilsample.feature.weatherui

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherRepository
import com.gpeal.droidconanvilsample.utils.DaggerComponentOwner
import com.gpeal.droidconanvilsample.utils.bindings
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel(application: Application) : AndroidViewModel(application), DaggerComponentOwner {

    override val daggerComponent = application.bindings<WeatherComponent.ParentBindings>().weatherComponentBuilder().create()

    @Inject
    lateinit var weatherRepository: WeatherRepository

    init {
        bindings<WeatherBindings>().inject(this)

        viewModelScope.launch {
            Toast.makeText(application, "Forecast=${weatherRepository.getForecast()}", Toast.LENGTH_SHORT).show()
        }
    }
}

class WeatherFragmentWithViewModel : Fragment(R.layout.weather_fragment) {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
    }
}