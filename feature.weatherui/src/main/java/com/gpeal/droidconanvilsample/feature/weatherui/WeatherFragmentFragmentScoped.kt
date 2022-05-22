package com.gpeal.droidconanvilsample.feature.weatherui

import android.content.Context
import androidx.fragment.app.Fragment
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherRepository
import com.gpeal.droidconanvilsample.utils.DaggerComponentOwner
import com.gpeal.droidconanvilsample.utils.bindings
import com.gpeal.droidconanvilsample.utils.fragmentComponent
import javax.inject.Inject

class WeatherFragmentFragmentScoped : Fragment(R.layout.weather_fragment), DaggerComponentOwner {
    override val daggerComponent: WeatherComponent by fragmentComponent { _, app ->
        // If you want a ViewModel scoped component, just instantiate this component inside of your ViewModel.
        // You instantiate this component anywhere, really.
        app.bindings<WeatherComponent.ParentBindings>().weatherComponentBuilder().create()
    }

    @Inject
    lateinit var weatherRepository: WeatherRepository

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindings<WeatherBindings>().inject(this)
    }
}