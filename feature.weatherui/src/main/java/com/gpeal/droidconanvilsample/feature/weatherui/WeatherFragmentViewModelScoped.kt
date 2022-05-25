package com.gpeal.droidconanvilsample.feature.weatherui

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherRepository
import com.gpeal.droidconanvilsample.utils.DaggerComponentOwner
import com.gpeal.droidconanvilsample.utils.bindings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherViewModel(application: Application) : AndroidViewModel(application), DaggerComponentOwner {

    override val daggerComponent = application.bindings<WeatherComponent.ParentBindings>().weatherComponentBuilder().create()

    @Inject
    lateinit var weatherRepository: WeatherRepository

    private val _result = MutableStateFlow<List<Int>>(emptyList())
    val result: Flow<List<Int>> = _result

    init {
        bindings<WeatherBindings>().inject(this)

        viewModelScope.launch {
            _result.value = weatherRepository.getForecast()
        }
    }
}

class WeatherFragmentWithViewModel : Fragment(R.layout.weather_fragment) {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launchWhenStarted {
            viewModel.result.collect {
                view.findViewById<TextView>(R.id.message).text = "Forecast=$it"
            }
        }
    }
}