package com.gpeal.droidconanvilsample.app

import android.app.Application
import com.gpeal.droidconanvilsample.utils.DaggerComponentOwner

open class MainApplication : Application(), DaggerComponentOwner {
    override lateinit var daggerComponent: Any

    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerAppComponent.create()
    }
}