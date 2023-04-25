package com.mldz.core_network_impl.di

import com.mldz.core_network_api.data.HttpClient
import com.mldz.core_network_impl.data.HttpClientImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class NetworkModule {

    @Singleton
    @Binds
    abstract fun provideHttpClient(httpClient: HttpClientImpl): HttpClient
}