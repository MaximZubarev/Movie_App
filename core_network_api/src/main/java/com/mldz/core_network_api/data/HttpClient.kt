package com.mldz.core_network_api.data

import com.mldz.core_network_api.model.movie.coming.ComingSoonData
import com.mldz.core_network_api.model.movie.popular.MostPopularData
import com.mldz.core_network_api.model.movie.theatre.InTheatreData
import com.mldz.core_network_api.model.movie.top.Top250Data


interface HttpClient {

    suspend fun getNowInTheatreMovies(): InTheatreData

    suspend fun getComingSoonMovies(): ComingSoonData

    suspend fun getPopularMovies(): MostPopularData

    suspend fun getTopMovies(): Top250Data
}