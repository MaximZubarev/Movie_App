package com.mldz.movieapp.di

import com.mldz.core_network_api.data.HttpClient
import com.mldz.core_network_impl.di.CoreNetworkComponent
import com.mldz.feature_main_api.MainFeatureApi
import com.mldz.feature_main_impl.di.MainFeatureComponentHolder
import com.mldz.feature_main_impl.di.MainFeatureDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideMainFeatureDependencies(): MainFeatureDependencies {
        return object: MainFeatureDependencies {
            override fun httpClient(): HttpClient = CoreNetworkComponent.get().httpClient()
        }
    }

    @Provides
    fun provideMainFeature(dependencies: MainFeatureDependencies): MainFeatureApi {
        MainFeatureComponentHolder.init(dependencies)
        return MainFeatureComponentHolder.get()
    }
}