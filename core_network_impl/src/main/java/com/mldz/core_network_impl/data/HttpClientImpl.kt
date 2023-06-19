package com.mldz.core_network_impl.data

import com.mldz.core_network_api.data.HttpClient
import com.mldz.core_network_api.model.movie.coming.ComingSoonData
import com.mldz.core_network_api.model.movie.popular.MostPopularData
import com.mldz.core_network_api.model.movie.theatre.InTheatreData
import com.mldz.core_network_api.model.movie.top.Top250Data
import com.mldz.core_network_impl.retrofit.MovieApi
import javax.inject.Inject


class HttpClientImpl @Inject constructor(private val api: MovieApi): HttpClient {

    override suspend fun getNowInTheatreMovies(): InTheatreData {
        return api.getNowInTheatre()
    }

    override suspend fun getComingSoonMovies(): ComingSoonData {
        return api.getComingSoon()
    }

    override suspend fun getPopularMovies(): MostPopularData {
        return api.getPopular()
    }

    override suspend fun getTopMovies(): Top250Data {
        return api.getTop250()
    }
}