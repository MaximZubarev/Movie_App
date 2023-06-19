package com.mldz.feature_main_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mldz.core_utils.di.general.asResult
import com.mldz.feature_main_impl.domain.MovieRepository
import com.mldz.feature_main_impl.models.Movie
import com.mldz.core_utils.di.general.Result
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class MainViewModel @Inject constructor(
    movieRepository: MovieRepository
): ViewModel() {

    private val inTheatreMovies: Flow<Result<List<Movie>>> = movieRepository.getNowInTheatreMovies().asResult()

    private val comingSoonMovies: Flow<Result<List<Movie>>> = movieRepository.getComingSoonMovies().asResult()

    private val popularMovies: Flow<Result<List<Movie>>> = movieRepository.getPopularMovies().asResult()

    private val top250Movies: Flow<Result<List<Movie>>> = movieRepository.getTop250Movies().asResult()

    val uiState: StateFlow<MainScreenUiState> = combine(
        inTheatreMovies,
        comingSoonMovies,
        popularMovies,
        top250Movies,
    ) { theatre, coming, popular, top ->
        val pair1 = Pair(theatre, coming)
        val pair2 = Pair(popular, top)
        Pair(pair1, pair2)
    }
        .map {
            getMainScreenState(it)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainScreenUiState(
                type = Type.MovieType(
                    movies = MovieData(MoviesState.Loading, MoviesState.Loading, MoviesState.Loading, MoviesState.Loading)
                )
            )
        )

    private fun getMainScreenState(
        movies: Pair<Pair<Result<List<Movie>>, Result<List<Movie>>>,
            Pair<Result<List<Movie>>, Result<List<Movie>>>>
    ): MainScreenUiState {
        val theatre = getState(movies.first.first)
        val coming = getState(movies.first.second)
        val popular = getState(movies.second.first)
        val top = getState(movies.second.second)
        return MainScreenUiState(
            type = Type.MovieType(
                movies = MovieData(theatre, coming, popular, top)
            )
        )
    }

    private fun getState(movie: Result<List<Movie>>): MoviesState {
        return when(movie) {
            is Result.Success -> {
                MoviesState.Success(movie.data)
            }
            is Result.Error -> MoviesState.Error(movie.toString())
            is Result.Loading -> MoviesState.Loading
        }
    }
}