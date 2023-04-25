package com.mldz.core_network_impl.data

import com.mldz.core_network_api.data.HttpClient
import com.mldz.core_network_api.model.MostPopularData
import com.mldz.core_network_impl.retrofit.MovieApi
import javax.inject.Inject


class HttpClientImpl @Inject constructor(val api: MovieApi): HttpClient {

    override suspend fun getPopularMovies(): MostPopularData {
        return api.getPopular()
    }
}