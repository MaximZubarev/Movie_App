package com.mldz.core.usecases

import com.mldz.core.common.Result
import com.mldz.core.repositories.MovieRepository


class FetchMovies(private val repositoryImpl: MovieRepository) {
    suspend operator fun invoke(): Result<Any> {
        return repositoryImpl.fetchMovies()
    }
}