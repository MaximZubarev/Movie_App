package com.mldz.core_network_api.data

import com.mldz.core_network_api.model.MostPopularData


interface HttpClient {

    suspend fun getPopularMovies(): MostPopularData
}