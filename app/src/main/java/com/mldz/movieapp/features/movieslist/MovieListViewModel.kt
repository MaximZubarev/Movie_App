package com.mldz.movieapp.features.movieslist

import androidx.lifecycle.*
import com.mldz.movieapp.data.MovieRepository
import com.mldz.movieapp.features.moviesdetails.MovieDetailsViewModel
import com.mldz.movieapp.models.Movie
import kotlinx.coroutines.launch


class MovieListViewModel(private val repository: MovieRepository): ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            _movies.postValue(repository.loadMovies())
        }
    }

    class Factory(private val repo: MovieRepository) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieListViewModel(repository = repo) as T
        }
    }
}