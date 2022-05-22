package com.gpeal.droidconanvilsample

import com.gpeal.droidconanvilsample.app.AppScope
import com.gpeal.droidconanvilsample.utils.SingleIn
import javax.inject.Inject

@SingleIn(AppScope::class)
class UserPrefs @Inject constructor() {
    val dataSource: String = "WeatherChannel"
}
