package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mldz.feature_main_impl.R
import com.mldz.feature_main_impl.presentation.MovieData
import com.mldz.feature_main_impl.presentation.MoviesState
import com.mldz.feature_main_impl.presentation.Type


@Preview
@Composable
fun TypePreview() {
    Type(
        type = Type.MovieType(
            movies = MovieData(
                MoviesState.Loading,
                MoviesState.Loading,
                MoviesState.Loading,
                MoviesState.Loading
            )
        )
    )
}

@Composable
fun Type(
    type: Type
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleText(
            textRes = R.string.type_movies,
            isSelected = type is Type.MovieType,
            modifier = Modifier.weight(0.5f)
        )
        TitleText(
            textRes = R.string.type_series,
            isSelected = type is Type.TheatreType,
            modifier = Modifier.weight(0.5f)
        )
    }
}

@Composable
fun TitleText(
    textRes: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.height(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = textRes),
            modifier = modifier.fillMaxWidth(),
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(5.dp)
                    .background(Color.White)
            )
        }
    }
}