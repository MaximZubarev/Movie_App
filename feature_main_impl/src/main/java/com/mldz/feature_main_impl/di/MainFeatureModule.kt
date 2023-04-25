package com.mldz.feature_main_impl.di

import com.mldz.feature_main_api.MainScreen
import com.mldz.feature_main_impl.start.MainScreenImpl
import com.mldz.core_utils.di.general.PerFeature
import dagger.Binds
import dagger.Module


@Module
abstract class MainFeatureModule {

    @PerFeature
    @Binds
    abstract fun provideMainScreen(mainScreenImpl: MainScreenImpl): MainScreen
}