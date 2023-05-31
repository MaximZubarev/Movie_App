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

    private val popularMovies: Flow<Result<List<Movie>>> = movieRepository.getPopularMovies().asResult()

    private val comingSoonMovies: Flow<Result<List<Movie>>> = movieRepository.getComingSoonMovies().asResult()

    val uiState: StateFlow<MainScreenUiState> = combine(
        popularMovies,
        comingSoonMovies,
        ::Pair
    )
        .map {
            val popular = when(it.first) {
                is Result.Success -> {
                    MoviesState.Success((it.first as Result.Success<List<Movie>>).data)
                }
                is Result.Error -> MoviesState.Error(it.second.toString())
                is Result.Loading -> MoviesState.Loading
            }
            val coming = when(it.second) {
                is Result.Success -> {
                    MoviesState.Success((it.second as Result.Success<List<Movie>>).data)
                }
                is Result.Error -> MoviesState.Error(it.second.toString())
                is Result.Loading -> MoviesState.Loading
            }
            MainScreenUiState(popular, coming)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainScreenUiState(MoviesState.Loading, MoviesState.Loading)
        )
}