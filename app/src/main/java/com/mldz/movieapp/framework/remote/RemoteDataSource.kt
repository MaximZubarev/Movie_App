package com.mldz.movieapp.framework.remote

import com.mldz.core.data.MovieDataSource
import com.mldz.core.domain.Movie
import com.mldz.core.domain.MovieDetails
import com.mldz.core.domain.Result
import com.mldz.movieapp.utils.toMovie
import com.mldz.movieapp.utils.toMovieDetails


class RemoteDataSource(private val apiService: ApiService): MovieDataSource {

    suspend fun getConfiguration() = apiService.getConfiguration()

    override suspend fun getMovies(): Result<List<Movie>> {
        return try {
            val response = apiService.getMovies()
            if (response.isSuccessful) {
                response.body().let {
                    Result.Success(response.body()!!.results.map { it.toMovie() })
                }
            } else {
                Result.Error(Throwable(response.errorBody().toString()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getMovie(id: Long): Result<MovieDetails> {
        return try {
            val response = apiService.getMovie(id)
            if (response.isSuccessful) {
                response.body().let {
                    Result.Success(response.body()!!.toMovieDetails())
                }
            } else {
                Result.Error(Throwable(response.errorBody().toString()))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}