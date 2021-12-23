package com.mldz.movieapp.features.moviesdetails

import androidx.lifecycle.*
import com.mldz.movieapp.data.MovieRepository
import com.mldz.movieapp.models.Movie
import kotlinx.coroutines.launch


class MovieDetailsViewModel(private val repository: MovieRepository): ViewModel() {
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

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