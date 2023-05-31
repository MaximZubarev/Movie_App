package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mldz.core_design.R
import com.mldz.core_design.theme.BlueAnakiwa30
import com.mldz.core_design.theme.PurpleCold30
import com.mldz.core_design.theme.White20
import com.mldz.movieapp.models.MovieMenuItem


private val MOVIES_MENU = listOf(
    MovieMenuItem(
        1,
        R.drawable.ic_genres,
        R.string.movie_menu_genres
    ),
    MovieMenuItem(
        2,
        R.drawable.ic_tv_series,
        R.string.movie_menu_tv_series
    ),
    MovieMenuItem(
        3,
        R.drawable.ic_movies,
        R.string.movie_menu_movies
    ),
    MovieMenuItem(
        4,
        R.drawable.ic_cinema,
        R.string.movie_menu_in_theatre
    )
)

@Preview
@Composable
fun MoviesMenuPreview() {
    MoviesMenu()
}

@Composable
fun MoviesMenu() {
    val spaceSizeBetween = 17.dp
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = paddingHorizontal,
                end = paddingHorizontal - spaceSizeBetween
            )
    ) {
        MOVIES_MENU.forEach {
            MovieMenuCard(movie = it)
            Spacer(modifier = Modifier.size(spaceSizeBetween))
        }
    }
}

@Composable
fun RowScope.MovieMenuCard(
    movie: MovieMenuItem
) {
    val shape = RoundedCornerShape(15.dp)
    Column(
        modifier = Modifier
            .weight(1f)
            .clip(shape = shape)
            .border(
                width = 1.dp,
                color = White20,
                shape = shape
            )
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(PurpleCold30, BlueAnakiwa30)
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(28.dp))
        Image(
            painter = painterResource(id = movie.image),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(31.dp)
                .height(31.dp)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = stringResource(id = movie.title),
            fontSize = 9.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(14.dp))
    }
}