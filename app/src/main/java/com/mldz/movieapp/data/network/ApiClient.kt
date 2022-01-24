package com.mldz.movieapp.data.network


class ApiClient(private val apiService: ApiService) {

    suspend fun getConfiguration() = apiService.getConfiguration()

    suspend fun getMovies() = apiService.getMovies()

    suspend fun getMovie(movieId: Int?) = apiService.getMovie(movieId)
}