package com.mldz.feature_main_impl.di

import com.mldz.core_network_api.data.HttpClient
import com.mldz.module_injector.BaseDependencies


interface MainFeatureDependencies: BaseDependencies {

    fun httpClient(): HttpClient
}