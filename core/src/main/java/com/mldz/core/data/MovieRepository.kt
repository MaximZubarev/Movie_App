package com.mldz.core.data

import com.mldz.core.domain.Movie
import com.mldz.core.domain.MovieDetails
import com.mldz.core.domain.Result


class MovieRepository(
    private val remoteDataSource: MovieDataSource,
    private val localDataSource: MovieDataSource
) {
    suspend fun getMovies(): Result<List<Movie>> {
        return remoteDataSource.getMovies().also {  }
    }

    suspend fun getMovie(id: Long): Result<MovieDetails> {
        return remoteDataSource.getMovie(id)
    }
}