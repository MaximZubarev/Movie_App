package com.mldz.movieapp.data.repository

import com.mldz.movieapp.data.model.BaseApiResponse
import com.mldz.movieapp.data.model.Movie
import com.mldz.movieapp.data.model.MovieListItem
import com.mldz.movieapp.data.model.MovieList
import com.mldz.movieapp.data.network.ApiClient
import com.mldz.movieapp.utils.Resource

interface MovieRepository {
    suspend fun loadMovies(): Resource<MovieList>
    suspend fun loadMovie(movieId: Int): Resource<Movie>
}

internal class RemoteMovieRepository(private val apiClient: ApiClient): MovieRepository, BaseApiResponse() {
    override suspend fun loadMovies(): Resource<MovieList> = safeApiCall { apiClient.getMovies() }

    override suspend fun loadMovie(movieId: Int): Resource<Movie> {
        return safeApiCall { apiClient.getMovie(movieId) }
    }
}