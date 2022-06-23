package com.mldz.core.usecases

import com.mldz.core.entities.Movie
import com.mldz.core.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow


class GetMovies(private val repositoryImpl: MovieRepository) {
    operator fun invoke(): Flow<List<Movie>> {
        return repositoryImpl.getMovies()
    }
}