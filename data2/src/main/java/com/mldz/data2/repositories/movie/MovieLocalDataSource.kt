package com.mldz.data2.repositories.movie

import com.mldz.core.entities.Movie
import com.mldz.core.entities.MovieDetails
import kotlinx.coroutines.flow.Flow


interface MovieLocalDataSource {
    fun getMovies(): Flow<List<Movie>>
    fun getMovie(id: String): Flow<MovieDetails>
    suspend fun deleteAll()
    suspend fun insert(movies: List<Movie>)
    suspend fun update(movieDetails: MovieDetails)
}