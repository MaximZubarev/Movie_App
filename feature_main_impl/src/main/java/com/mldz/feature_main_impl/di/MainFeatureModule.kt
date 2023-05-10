package com.mldz.feature_main_impl.di

import com.mldz.feature_main_impl.start.MainScreenImpl
import com.mldz.core_utils.di.general.PerFeature
import com.mldz.feature_main_api.MainScreenStarter
import com.mldz.feature_main_impl.data.MovieRepositoryImpl
import com.mldz.feature_main_impl.domain.MovieRepository
import dagger.Binds
import dagger.Module


@Module
abstract class MainFeatureModule {

    @PerFeature
    @Binds
    abstract fun provideMainScreen(mainScreenImpl: MainScreenImpl): MainScreenStarter

    @PerFeature
    @Binds
    abstract fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}