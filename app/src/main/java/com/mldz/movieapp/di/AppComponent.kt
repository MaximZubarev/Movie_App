package com.mldz.movieapp.di

import com.mldz.movieapp.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(
    modules = [AppModule::class]
)
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}