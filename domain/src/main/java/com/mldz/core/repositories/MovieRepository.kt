package com.mldz.core.repositories

import com.mldz.core.entities.Movie
import com.mldz.core.common.Result
import com.mldz.core.entities.MovieDetails
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    suspend fun fetchMovies(): Result<Any>
    suspend fun getRemoteMovie(id: String): Result<Any>
    fun getMovies(): Flow<List<Movie>>
    fun getMovie(id: String): Flow<MovieDetails>
}