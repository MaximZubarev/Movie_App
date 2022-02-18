package com.mldz.movieapp.presentation.movieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mldz.core.domain.Movie
import com.mldz.core.domain.Result
import com.mldz.core.usecases.GetMovies
import com.mldz.movieapp.utils.Resource
import kotlinx.coroutines.launch


class MovieListViewModel(
        private val getMovies: GetMovies
    ): ViewModel() {

    private val _response = MutableLiveData<Resource<List<Movie>>>()
    val response = _response

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            when (val result = getMovies.invoke()) {
                is Result.Error -> onError(result.throwable)
                is Result.Success -> onSuccess(result.data)
            }
        }
    }

    private fun onSuccess(movies: List<Movie>) {
        if (movies.isEmpty()) {
            _response.postValue(Resource.success(listOf()))
        } else {
            _response.postValue(Resource.success(movies))
        }
    }

    private fun onError(e: Throwable) {
        _response.postValue(Resource.error(null, e.message.toString()))
    }

    class Factory(
            private val getMovies: GetMovies
        ) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieListViewModel(
                getMovies = getMovies
            ) as T
        }
    }
}