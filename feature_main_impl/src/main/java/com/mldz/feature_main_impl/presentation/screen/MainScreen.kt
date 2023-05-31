package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mldz.feature_main_impl.presentation.MainViewModel


internal val popularItemWidth = 320.dp
internal val popularItemHeight = 140.dp
internal val paddingHorizontal = 32.dp


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
        TopBar()
        Popular(popularMoviesState = uiState.popularMoviesState)
        Spacer(modifier = Modifier.height(45.dp))
        MoviesMenu()
        Spacer(modifier = Modifier.size(35.dp))
        UpComing(upcomingReleases = uiState.comingSoonMoviesState)
    }
}