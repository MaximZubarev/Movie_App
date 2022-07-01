package com.mldz.movieapp.presentation.movieslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mldz.core.common.Result
import com.mldz.core.usecases.FetchMovies
import com.mldz.core.usecases.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MovieListViewModel @Inject constructor(
        private val getMovies: GetMovies,
        private val fetchMovies: FetchMovies
    ): ViewModel() {

    private val _movies = getMovies
        .invoke()
        .catch { onError(it) }
        .asLiveData()

    val movies = _movies

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading

    private val _error = MutableLiveData<String>()
    val error = _error

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                try {
                    fetchMovies.invoke()
                } catch (e: Exception) {
                    onError(e)
                }
            }
            if (result is Result.Error) {
                onError(result.throwable)
            }
            loading.postValue(false)
        }
    }

    private fun onError(e: Throwable) {
        _error.postValue(e.message)
    }
}