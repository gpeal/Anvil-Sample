package com.gpeal.droidconanvilsample.app

import android.app.Application
import com.gpeal.droidconanvilsample.utils.DaggerComponentOwner

class MainApplication : Application(), DaggerComponentOwner {
    override lateinit var daggerComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerAppComponent.create()
    }
}