package com.mldz.movieapp

import android.app.Application
import com.mldz.movieapp.manager.DataStoreManager


class App: Application() {
    private lateinit var dataStore: DataStoreManager

    override fun onCreate() {
        super.onCreate()

        dataStore = DataStoreManager(this)
    }

    fun getDataStore() = dataStore
}