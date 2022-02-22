package com.mldz.core.usecases

import com.mldz.core.data.MovieRepository
import com.mldz.core.domain.MovieDetails
import com.mldz.core.domain.Result


class GetMovie(private val repository: MovieRepository) {
    suspend operator fun invoke(id: Long): Result<MovieDetails> {
        return repository.getMovie(id)
    }
}