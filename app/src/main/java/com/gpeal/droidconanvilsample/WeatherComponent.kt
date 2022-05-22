package com.gpeal.droidconanvilsample

import com.gpeal.droidconanvilsample.app.AppComponent
import com.gpeal.droidconanvilsample.app.AppScope
import com.gpeal.droidconanvilsample.utils.SingleIn
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.BindsInstance
import dagger.Subcomponent
import kotlinx.coroutines.CoroutineScope

interface WeatherScope

@SingleIn(WeatherScope::class)
@MergeSubcomponent(WeatherScope::class)
interface WeatherComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun coroutineScope(scope: CoroutineScope): Builder
        fun build(): WeatherComponent
    }

    @ContributesTo(AppScope::class)
    interface ParentBindings {
        fun weatherComponentBuilder(): Builder
    }
}
