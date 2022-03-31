package com.mldz.movieapp.framework.local

import com.mldz.core.data.MovieDataSource
import com.mldz.core.domain.Movie
import com.mldz.core.domain.MovieDetails
import com.mldz.core.domain.Result
import com.mldz.movieapp.framework.local.dao.MovieDao
import com.mldz.movieapp.utils.toMovie
import com.mldz.movieapp.utils.toMovieDetails


class LocalDataSource(private val movieDao: MovieDao): MovieDataSource {
    override suspend fun getMovies(): Result<List<Movie>> {
        return try {
            val movies: List<Movie> = movieDao.getMovies().map { it.toMovie() }
            if (movies.isNotEmpty()) {
                Result.Error(NullPointerException())
            }
            Result.Success(movies)
        } catch (e: Throwable) {
            Result.Error(e)
        }
    }

    override suspend fun getMovie(id: Long): Result<MovieDetails> {
        return try {
            movieDao.getMovie(id).toMovieDetails().let {
                Result.Success(it)
            }
        } catch (e: Throwable) {
            Result.Error(e)
        }
    }
}