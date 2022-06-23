package com.mldz.core.usecases

import com.mldz.core.entities.MovieDetails
import com.mldz.core.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow


class GetMovie(private val repositoryImpl: MovieRepository) {
    operator fun invoke(id: String): Flow<MovieDetails> {
        return repositoryImpl.getMovie(id)
    }
}