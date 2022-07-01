package com.mldz.movieapp.presentation.moviesdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mldz.core.entities.MovieDetails
import com.mldz.core.usecases.FetchMovie
import com.mldz.core.usecases.GetMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovie: GetMovie,
    private val fetchMovie: FetchMovie
) : ViewModel() {
    private val _movie = MutableLiveData<MovieDetails>()
    val movie = _movie

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading

    private val _error = MutableLiveData<String>()
    val error = _error

    fun loadMovie(movieId: String) {
        loading.value = true
        viewModelScope.launch() {
            launch {
                getMovie
                    .invoke(movieId)
                    .catch {
                        emit(MovieDetails())
                        onError(it)
                    }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.Eagerly,
                        initialValue = MovieDetails(id = "t")
                    )
                    .collect {
                        onSuccess(it)
                        loading.setValue(false)
                    }
            }

            launch {
                try {
                    fetchMovie.invoke(movieId)
                } catch (e: Exception) {
                    onError(e)
                }
            }
        }
    }

    private fun onSuccess(movie: MovieDetails) {
        _movie.postValue(movie)
    }

    private fun onError(e: Throwable) {
        _error.postValue(e.message)
    }
}