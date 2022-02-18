package com.mldz.core.data

import com.mldz.core.domain.Movie
import com.mldz.core.domain.Result


class MovieRepository(private val dataSource: MovieDataSource) {
    suspend fun getMovies(): Result<List<Movie>> {
        return dataSource.getMovies()
    }

    suspend fun getMovie(id: Long): Result<Movie> {
        return dataSource.getMovie(id)
    }
}