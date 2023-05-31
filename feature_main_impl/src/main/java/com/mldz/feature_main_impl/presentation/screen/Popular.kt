package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mldz.core_design.R
import com.mldz.core_design.theme.BlackCodGray
import com.mldz.core_design.theme.BlackCodGray00
import com.mldz.core_design.theme.Shapes
import com.mldz.core_utils.ui.shimmerBackground
import com.mldz.feature_main_impl.models.Movie
import com.mldz.feature_main_impl.presentation.MoviesState


@Composable
fun Popular(
    popularMoviesState: MoviesState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(top = 26.dp)
    ) {
        Text(
            text = stringResource(id = R.string.most_popular),
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = paddingHorizontal)
        )
        when(popularMoviesState) {
            is MoviesState.Error -> {}
            is MoviesState.Loading -> {
                PopularLoader(modifier = Modifier.padding(start = paddingHorizontal))
            }
            is MoviesState.Success -> {
                LazyRow(
                    modifier = Modifier.padding(top = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(horizontal = paddingHorizontal)
                ) {
                    items(popularMoviesState.movies) { movie -> MoviePopularItem(movie = movie) }
                }
            }
        }
    }
}

@Composable
fun PopularLoader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(popularItemWidth)
            .height(popularItemHeight)
            .padding(top = 15.dp)
            .shimmerBackground(Shapes.large)
    )
}

@Composable
fun MoviePopularItem(movie: Movie) {
    Card(
        modifier = Modifier
            .width(popularItemWidth)
            .height(popularItemHeight),
        shape = Shapes.large,
        elevation = 8.dp
    ) {
        AsyncImage(
            model = movie.imagePath,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(BlackCodGray00, BlackCodGray)
                    )
                )
        ) {
            Text(
                text = movie.title,
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        bottom = 15.dp
                    )
                    .align(Alignment.BottomStart),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}