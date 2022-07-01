package com.mldz.data2.repositories.movie

import com.mldz.core.common.Result
import com.mldz.core.entities.Movie
import com.mldz.core.entities.MovieDetails
import com.mldz.data2.api.ApiServiceImdb
import com.mldz.data2.api.model.BaseApiResponse
import com.mldz.data2.mappers.MovieApiMapper


class MovieRemoteDataSourceImpl (
    private val service: ApiServiceImdb,
    private val mapper: MovieApiMapper
): MovieRemoteDataSource, BaseApiResponse() {
    override suspend fun getMovies(): Result<List<Movie>> {
        return try {
            val response = service.getMovies()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Result.Success(body.items.take(10).map { item ->
                        mapper.toMovie(item)
                    })
                }
            }
            return Result.Error(java.lang.Exception("${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getMovie(id: String): Result<MovieDetails> {
        val res = safeApiCall { service.getMovie(id) }
        if (res is Result.Success) {
            return Result.Success(mapper.toMovieDetails(res.data))
        } else if (res is Result.Error) {
            return Result.Error(res.throwable)
        }
        return Result.Error(Throwable())
    }
}