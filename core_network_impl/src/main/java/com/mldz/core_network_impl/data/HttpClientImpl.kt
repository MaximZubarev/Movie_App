package com.mldz.core_network_impl.data

import com.mldz.core_network_api.data.HttpClient
import com.mldz.core_network_api.model.ComingSoonData
import com.mldz.core_network_api.model.MostPopularData
import com.mldz.core_network_impl.retrofit.MovieApi
import javax.inject.Inject


class HttpClientImpl @Inject constructor(private val api: MovieApi): HttpClient {

    override suspend fun getPopularMovies(): MostPopularData {
        return api.getPopular()
    }

    override suspend fun getComingSoonMovies(): ComingSoonData {
        return api.getComingSoon()
    }
}