package com.gpeal.droidconanvilsample.feature.weatherui

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    private val _result = MutableLiveData<List<Int>>()
    val result: LiveData<List<Int>> = _result

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
        viewModel.result.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.message).text = "Forecast=$it"
        }
    }
}