package com.mldz.movieapp.data.repository

import com.mldz.movieapp.data.model.BaseApiResponse
import com.mldz.movieapp.data.model.Configuration
import com.mldz.movieapp.data.network.ApiClient
import com.mldz.movieapp.utils.Resource


class ConfigRepository(private val apiClient: ApiClient): BaseApiResponse() {
    suspend fun getConfiguration(): Resource<Configuration> = safeApiCall { apiClient.getConfiguration() }
}