package com.mldz.core.usecases

import com.mldz.core.data.MovieRepository
import com.mldz.core.domain.Movie
import com.mldz.core.domain.Result


class GetMovies(private val repository: MovieRepository) {
    suspend operator fun invoke(): Result<List<Movie>> {
        return repository.getMovies()
    }
}