package com.mldz.movieapp.presentation.moviesdetails

import androidx.lifecycle.*
import com.mldz.core.domain.Movie
import com.mldz.core.domain.MovieDetails
import com.mldz.core.domain.Result
import com.mldz.core.usecases.GetMovie
import com.mldz.movieapp.utils.Resource
import kotlinx.coroutines.launch


class MovieDetailsViewModel(private val getMovie: GetMovie): ViewModel() {
    private val _movie = MutableLiveData<Resource<MovieDetails>>()
    val movie: LiveData<Resource<MovieDetails>> = _movie

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading

    fun loadMovie(movieId: Long) {
        loading.value = true
        viewModelScope.launch {
            when (val result = getMovie.invoke(movieId)) {
                is Result.Success -> onSuccess(result.data)
                is Result.Error -> onError(result.throwable)
            }
            loading.postValue(false)
        }
    }

    private fun onSuccess(movie: MovieDetails) {
        if (movie.id > 0) {
            _movie.postValue(Resource.success(movie))
        } else {
            _movie.postValue(Resource.error(null, "empty"))
        }
    }

    private fun onError(e: Throwable) {
        _movie.postValue(Resource.error(null, e.message.toString()))
    }

    class Factory(private val getMovie: GetMovie) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieDetailsViewModel(getMovie = getMovie) as T
        }
    }
}