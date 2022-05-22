package com.gpeal.droidconanvilsample.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpeal.droidconanvilsample.feature.weatherui.R
import com.gpeal.droidconanvilsample.feature.weatherui.WeatherFragmentSimple
import com.gpeal.droidconanvilsample.feature.weatherui.WeatherFragmentWithViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherFragmentWithViewModel())
                .commitNow()
        }
    }
}