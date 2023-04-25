package com.mldz.movieapp

import android.app.Application
import com.mldz.movieapp.di.AppComponent
import com.mldz.movieapp.di.DaggerAppComponent


class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}