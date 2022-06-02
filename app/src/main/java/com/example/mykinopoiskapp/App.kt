package com.example.mykinopoiskapp

import android.app.Application
import com.example.mykinopoiskapp.di.AppComponent
import com.example.mykinopoiskapp.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(applicationContext)
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}