package com.mldz.core.data

import com.mldz.core.domain.Movie
import com.mldz.core.domain.MovieDetails
import com.mldz.core.domain.Result


interface MovieDataSource {
    suspend fun getMovies(): Result<List<Movie>>
    suspend fun getMovie(id: Long): Result<MovieDetails>
}