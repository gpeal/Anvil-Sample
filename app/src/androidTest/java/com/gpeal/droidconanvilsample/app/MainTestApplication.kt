package com.gpeal.droidconanvilsample.app

class MainTestApplication : MainApplication() {

    override lateinit var daggerComponent: Any

    override fun onCreate() {
        super.onCreate()
        daggerComponent = DaggerTestAppComponent.create()
    }
}