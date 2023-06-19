package com.mldz.feature_main_impl.presentation

import com.mldz.feature_main_impl.models.Movie


data class MainScreenUiState(
    val type: Type
)

sealed interface Type {
    class MovieType(val movies: MovieData): Type
    class TheatreType(val theatre: TheatreData): Type
}

data class MovieData(
    val inTheatreMoviesState: MoviesState,
    val comingSoonMoviesState: MoviesState,
    val popularMoviesState: MoviesState,
    val top250MoviesState: MoviesState,
)

data class TheatreData(
    val data: Any
)

sealed interface MoviesState {
    class Success(val movies: List<Movie>): MoviesState
    class Error(val message: String): MoviesState
    object Loading: MoviesState
}
