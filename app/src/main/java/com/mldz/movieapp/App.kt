package com.mldz.movieapp

import android.app.Application
import androidx.room.Room
import com.mldz.movieapp.framework.local.AppDatabase


class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "movie_app.db"
        ).build()
    }
}