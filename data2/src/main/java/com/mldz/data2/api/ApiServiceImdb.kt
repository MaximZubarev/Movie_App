package com.mldz.data2.api

import com.mldz.data2.api.model.MovieListResponse
import com.mldz.data2.api.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiServiceImdb {

    companion object {
        private const val API_KEY = "k_c1tkgo67"
    }

    @GET("Top250Movies/${API_KEY}")
    suspend fun getMovies(): Response<MovieListResponse>

    @GET("Title/${API_KEY}/{id}")
    suspend fun getMovie(@Path("id") movieId: String): Response<MovieResponse>
}