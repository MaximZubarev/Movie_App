package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mldz.feature_main_impl.R
import com.mldz.feature_main_impl.presentation.MainViewModel
import com.mldz.feature_main_impl.presentation.Type


internal val paddingHorizontal = 20.dp


@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .systemBarsPadding()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Type(uiState.type)
        Spacer(modifier = Modifier.height(20.dp))
        if (uiState.type is Type.MovieType) {
            MoviesList(
                titleRes = R.string.in_theatres,
                moviesState = (uiState.type as Type.MovieType).movies.inTheatreMoviesState
            )
            Spacer(modifier = Modifier.size(20.dp))
            MoviesList(
                titleRes = R.string.upcoming_releases,
                moviesState = (uiState.type as Type.MovieType).movies.comingSoonMoviesState
            )
            Spacer(modifier = Modifier.size(20.dp))
            MoviesList(
                titleRes = R.string.most_popular,
                moviesState = (uiState.type as Type.MovieType).movies.popularMoviesState
            )
            Spacer(modifier = Modifier.size(20.dp))
            MoviesList(
                titleRes = R.string.top250,
                moviesState = (uiState.type as Type.MovieType).movies.top250MoviesState
            )
        }
    }
}