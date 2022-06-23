package com.mldz.data2.repositories.movie

import com.mldz.core.common.Result
import com.mldz.core.entities.Movie
import com.mldz.core.entities.MovieDetails
import com.mldz.core.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow


class MovieRepositoryImpl(
    private val remoteRepository: MovieRemoteDataSource,
    private val localRepository: MovieLocalDataSource
): MovieRepository {
    override suspend fun fetchMovies(): Result<Any> {
        return when (val res = remoteRepository.getMovies()) {
            is Result.Success -> {
                localRepository.insert(movies = res.data)
                Result.Success("")
            }
            is Result.Error -> res
            else -> Result.Error(Throwable())
        }
    }

    override suspend fun getRemoteMovie(id: String): Result<Any> {
        return when(val res = remoteRepository.getMovie(id)) {
            is Result.Success -> {
                localRepository.update(res.data)
                Result.Success("")
            }
            is Result.Error -> res
            else -> Result.Error(Throwable())
        }
    }

    override fun getMovies(): Flow<List<Movie>> {
        return localRepository.getMovies()
    }

    override fun getMovie(id: String): Flow<MovieDetails> {
        return localRepository.getMovie(id)
    }
}