package com.mldz.core_network_impl.retrofit

import com.mldz.core_network_api.model.movie.coming.ComingSoonData
import com.mldz.core_network_api.model.movie.popular.MostPopularData
import com.mldz.core_network_api.model.movie.theatre.InTheatreData
import com.mldz.core_network_api.model.movie.top.Top250Data
import retrofit2.http.GET


interface MovieApi {

    @GET("/ru/API/InTheaters")
    suspend fun getNowInTheatre(): InTheatreData

    @GET("/ru/API/ComingSoon")
    suspend fun getComingSoon(): ComingSoonData

    @GET("/ru/API/MostPopularMovies")
    suspend fun getPopular(): MostPopularData

    @GET("/ru/API/Top250Movies")
    suspend fun getTop250(): Top250Data
}