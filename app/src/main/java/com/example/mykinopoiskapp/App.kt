package com.example.mykinopoiskapp

import android.app.Application
import com.example.mykinopoiskapp.di.AppComponent
import com.example.mykinopoiskapp.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}