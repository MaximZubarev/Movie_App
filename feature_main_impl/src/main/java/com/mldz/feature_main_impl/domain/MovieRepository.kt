package com.mldz.feature_main_impl.domain

import com.mldz.feature_main_impl.models.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

    fun getNowInTheatreMovies(): Flow<List<Movie>>

    fun getComingSoonMovies(): Flow<List<Movie>>

    fun getPopularMovies(): Flow<List<Movie>>

    fun getTop250Movies(): Flow<List<Movie>>
}