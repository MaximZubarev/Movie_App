package com.mldz.movieapp.data.network

import com.mldz.movieapp.data.model.Configuration
import com.mldz.movieapp.data.model.Movie
import com.mldz.movieapp.data.model.MovieListItem
import com.mldz.movieapp.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = "6832cc928cd2af0a4f0a5d8434a3476d"
    }

    @GET("configuration?api_key=${API_KEY}")
    suspend fun getConfiguration(): Response<Configuration>

    @GET("movie/top_rated?api_key=${API_KEY}&language=en-US&page=1")
    suspend fun getMovies(): Response<MovieList>

    @GET("movie/{id}?api_key=${API_KEY}&language=en-US")
    suspend fun getMovie(@Path("id") movieId: Int?): Response<Movie>
}