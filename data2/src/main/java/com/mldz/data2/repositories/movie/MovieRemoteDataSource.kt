package com.mldz.data2.repositories.movie

import com.mldz.core.entities.Movie
import com.mldz.core.common.Result
import com.mldz.core.entities.MovieDetails


interface MovieRemoteDataSource {
    suspend fun getMovies(): Result<List<Movie>>
    suspend fun getMovie(id: String): Result<MovieDetails>
}