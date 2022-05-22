package com.gpeal.droidconanvilsample.feature.weatherui

import android.content.Context
import androidx.fragment.app.Fragment
import com.gpeal.droidconanvilsample.lib.daggerscopes.WeatherScope
import com.gpeal.droidconanvilsample.lib.weatherdata.WeatherRepository
import com.gpeal.droidconanvilsample.lib.daggerscopes.utils.DaggerComponentOwner
import com.gpeal.droidconanvilsample.lib.daggerscopes.utils.bindings
import com.gpeal.droidconanvilsample.lib.daggerscopes.utils.fragmentComponent
import com.squareup.anvil.annotations.ContributesTo
import javax.inject.Inject

@ContributesTo(WeatherScope::class)
interface WeatherBindings {
    fun inject(fragment: WeatherFragment)
}

class WeatherFragment : Fragment(R.layout.main_fragment), DaggerComponentOwner {
    override val daggerComponent: WeatherComponent by fragmentComponent { _, app ->
        app.bindings<WeatherComponent.ParentBindings>().weatherComponentBuilder().create()
    }

    @Inject
    lateinit var weatherRepository: WeatherRepository

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindings<WeatherBindings>().inject(this)
    }
}