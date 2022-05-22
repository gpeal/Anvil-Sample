package com.gpeal.droidconanvilsample

import android.content.Context
import androidx.fragment.app.Fragment
import com.gpeal.droidconanvilsample.utils.DaggerComponentOwner
import com.gpeal.droidconanvilsample.utils.fragmentComponent
import com.squareup.anvil.annotations.ContributesTo
import javax.inject.Inject

// This could live in the same leaf impl/feature module as the Fragment.
@ContributesTo(WeatherScope::class)
interface WeatherBindings {
    fun inject(fragment: WeatherFragment)
}

class WeatherFragment : Fragment(R.layout.main_fragment), DaggerComponentOwner {

    override val daggerComponent: WeatherComponent by fragmentComponent { coroutineScope, app ->
        app.bindings<WeatherComponent.ParentBindings>().weatherComponentBuilder()
            .coroutineScope(coroutineScope)
            .build()
    }

    @Inject
    lateinit var weatherRepository: WeatherRepository

    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindings<WeatherBindings>().inject(this)
    }
}