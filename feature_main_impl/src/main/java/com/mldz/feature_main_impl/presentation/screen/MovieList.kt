package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mldz.core_design.R
import com.mldz.feature_main_impl.models.Movie
import com.mldz.feature_main_impl.presentation.MoviesState


private var spaceBetweenItems = 20.dp

@Preview
@Composable
fun MoviesListPreview() {
    MoviesList(
        titleRes = R.string.type_movies,
        moviesState = MoviesState.Success(listOf(
        Movie(
            id = "test",
            imagePath = "image",
            title = "test",
            year = "2023",
            rating = "8"
        )
    )))
}

@Composable
fun MoviesList(
    titleRes: Int,
    moviesState: MoviesState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Top(
            titleRes = titleRes
        )
        Spacer(modifier = Modifier.size(20.dp))
        List(
            moviesState = moviesState
        )
    }
}

@Composable
fun Top(
    titleRes: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(end = paddingHorizontal),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Title(
            titleRes = titleRes,
            modifier = modifier.weight(1f)
        )
        SeeAllText()
    }
}

@Composable
fun Title(
    titleRes: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = titleRes),
        fontSize = 18.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(start = paddingHorizontal)
    )
}

@Composable
fun SeeAllText() {
    Text(
        text = stringResource(id = R.string.see_all),
        fontSize = 14.sp,
        color = Color.LightGray,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun List(
    moviesState: MoviesState,
    modifier: Modifier = Modifier
) {
    when(moviesState) {
        is MoviesState.Error -> {}
        is MoviesState.Loading -> {
            Row(
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenItems)
            ) {
                MovieItemLoader(modifier = modifier.padding(start = paddingHorizontal))
                MovieItemLoader(modifier = modifier.padding(start = paddingHorizontal))
            }
        }
        is MoviesState.Success -> {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenItems),
                contentPadding = PaddingValues(horizontal = paddingHorizontal)
            ) {
                items(moviesState.movies) { movie ->
                    MovieItem(movie = movie)
                }
            }
        }
    }
}