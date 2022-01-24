package com.mldz.movieapp.features.moviesdetails

import androidx.lifecycle.*
import com.mldz.movieapp.data.model.Movie
import com.mldz.movieapp.data.model.MovieListItem
import com.mldz.movieapp.data.repository.MovieRepository
import com.mldz.movieapp.utils.Resource
import kotlinx.coroutines.launch


class MovieDetailsViewModel(private val repository: MovieRepository): ViewModel() {
    private val _movie = MutableLiveData<Resource<Movie>>()
    val localMovie: LiveData<Resource<Movie>> = _movie

    fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            _movie.postValue(repository.loadMovie(movieId))
        }
    }

    class Factory(private val repo: MovieRepository) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieDetailsViewModel(repository = repo) as T
        }
    }
}