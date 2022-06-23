package com.mldz.data2.repositories.movie

import com.mldz.core.entities.Movie
import com.mldz.core.entities.MovieDetails
import com.mldz.data2.db.MovieDao
import com.mldz.data2.mappers.MovieEntityMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


class MovieLocalDataSourceImpl(
    private val movieDao: MovieDao,
    private val dispatcher: CoroutineDispatcher,
    private val movieEntityMapper: MovieEntityMapper
): MovieLocalDataSource {
    override fun getMovies(): Flow<List<Movie>> {
        return movieDao.getMovies().map { list ->
            list.map {
                movieEntityMapper.toMovie(it)
            }
        }
    }

    override fun getMovie(id: String): Flow<MovieDetails> {
        return movieDao.getMovie(id).map { movieEntity -> movieEntityMapper.toMovieDetails(movieEntity) }
    }

    override suspend fun deleteAll() {
        movieDao.deleteAll()
    }

    override suspend fun insert(movies: List<Movie>) {
        withContext(dispatcher) {
            movieDao.insertAll(movies.map { movieEntityMapper.toMovieEntity(it) })
        }
    }

    override suspend fun update(movieDetails: MovieDetails) {
        movieDao.update(movieEntityMapper.toMovieEntity(movieDetails))
    }
}