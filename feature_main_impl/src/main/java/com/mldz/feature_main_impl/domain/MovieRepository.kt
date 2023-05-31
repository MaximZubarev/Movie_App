package com.mldz.feature_main_impl.domain

import com.mldz.feature_main_impl.models.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

    fun getPopularMovies(): Flow<List<Movie>>

    fun getComingSoonMovies(): Flow<List<Movie>>
}