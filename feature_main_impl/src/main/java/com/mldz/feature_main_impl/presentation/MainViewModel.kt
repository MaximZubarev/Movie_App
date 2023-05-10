package com.mldz.feature_main_impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mldz.core_utils.di.general.asResult
import com.mldz.feature_main_impl.domain.MovieRepository
import com.mldz.feature_main_impl.models.Movie
import com.mldz.core_utils.di.general.Result
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class MainViewModel(
    movieRepository: MovieRepository
): ViewModel() {

    private val popularMovies: Flow<Result<List<Movie>>> = movieRepository.getPopularMovies().asResult()

    val uiState: StateFlow<MainScreenUiState> = popularMovies
        .map {
            val popular = when(it) {
                is Result.Success -> PopularMoviesState.Success(it.data)
                is Result.Error -> PopularMoviesState.Error
                is Result.Loading -> PopularMoviesState.Loading
            }
            MainScreenUiState(popular, PopularMoviesState.Error)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MainScreenUiState(PopularMoviesState.Loading, PopularMoviesState.Loading)
        )
}