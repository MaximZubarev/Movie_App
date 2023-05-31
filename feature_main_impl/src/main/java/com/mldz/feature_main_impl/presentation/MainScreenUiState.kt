package com.mldz.feature_main_impl.presentation

import com.mldz.feature_main_impl.models.Movie


data class MainScreenUiState(
    val popularMoviesState: MoviesState,
    val comingSoonMoviesState: MoviesState
)

sealed interface MoviesState {
    class Success(val movies: List<Movie>): MoviesState
    class Error(val message: String): MoviesState
    object Loading: MoviesState
}
