package com.mldz.core.usecases

import com.mldz.core.common.Result
import com.mldz.core.repositories.MovieRepository


class FetchMovie(private val repository: MovieRepository) {
    suspend operator fun invoke(id: String): Result<Any> = repository.getRemoteMovie(id)
}