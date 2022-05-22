package com.gpeal.droidconanvilsample.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gpeal.droidconanvilsample.R
import com.gpeal.droidconanvilsample.WeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherFragment())
                .commitNow()
        }
    }
}