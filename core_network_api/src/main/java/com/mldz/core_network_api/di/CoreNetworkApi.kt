package com.mldz.core_network_api.di

import com.mldz.core_network_api.data.HttpClient
import com.mldz.module_injector.BaseApi


interface CoreNetworkApi: BaseApi {
    fun httpClient(): HttpClient
}