package com.mldz.movieapp.features.movieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mldz.movieapp.App
import com.mldz.movieapp.data.model.MovieList
import com.mldz.movieapp.data.repository.ConfigRepository
import com.mldz.movieapp.data.repository.MovieRepository
import com.mldz.movieapp.utils.Resource
import kotlinx.coroutines.launch


class MovieListViewModel(
        private val repository: MovieRepository,
        private val configRepository: ConfigRepository
    ): ViewModel() {

    private val _response = MutableLiveData<Resource<MovieList>>()
    val response = _response

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            _response.postValue(repository.loadMovies())
        }
    }

    class Factory(
            private val movieRepository: MovieRepository,
            private val configRepository: ConfigRepository
        ) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieListViewModel(
                repository = movieRepository,
                configRepository = configRepository
            ) as T
        }
    }
}