package com.mldz.feature_main_impl.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mldz.core_design.R
import com.mldz.feature_main_impl.models.Movie
import com.mldz.feature_main_impl.presentation.MoviesState


@Composable
fun UpComing(
    upcomingReleases: MoviesState
) {
    Column {
        Text(
            text = stringResource(id = R.string.upcoming_releases),
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 50.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(horizontal = 50.dp)
        ) {
            when (upcomingReleases) {
                is MoviesState.Loading -> {}
                is MoviesState.Error -> {
                    Log.d("TAGG", "UpComing: ${upcomingReleases.message}")
                }
                is MoviesState.Success -> {
                    items(upcomingReleases.movies) { movie -> UpComingItem(movie = movie) }
                }
            }
        }
    }
}

@Composable
fun UpComingItem(
    movie: Movie
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(215.dp),
        shape = RoundedCornerShape(30.dp),
        elevation = 8.dp
    ) {
        AsyncImage(
            model = movie.imagePath,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}