package com.mldz.feature_main_impl.presentation

import com.mldz.feature_main_impl.models.Movie


data class MainScreenUiState(
    val popularMoviesState: PopularMoviesState,
    val comingSoonMoviesState: PopularMoviesState
)

sealed interface PopularMoviesState {
    class Success(val movies: List<Movie>): PopularMoviesState
    object Error: PopularMoviesState
    object Loading: PopularMoviesState
}
