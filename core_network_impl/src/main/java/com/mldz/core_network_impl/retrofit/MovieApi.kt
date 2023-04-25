package com.mldz.core_network_impl.retrofit

import com.mldz.core_network_api.model.MostPopularData
import retrofit2.http.GET


interface MovieApi {

    @GET("/ru/API/MostPopularMovies")
    suspend fun getPopular(): MostPopularData
}