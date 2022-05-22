package com.gpeal.droidconanvilsample.lib.userprefs

import com.gpeal.droidconanvilsample.lib.daggerscopes.AppScope
import com.gpeal.droidconanvilsample.lib.daggerscopes.utils.SingleIn
import javax.inject.Inject

@SingleIn(AppScope::class)
class UserPrefs @Inject constructor() {
    val dataSource: String = "WeatherChannel"
}