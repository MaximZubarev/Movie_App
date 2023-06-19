package com.mldz.feature_main_impl.presentation.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mldz.core_design.theme.Shapes
import com.mldz.core_design.theme.YellowRipeLemon
import com.mldz.core_utils.ui.shimmerBackground
import com.mldz.feature_main_impl.R
import com.mldz.feature_main_impl.models.Movie


internal val itemWidth = 180.dp
internal val itemHeight = 270.dp
internal val spaceBetweenImageAndTitle = 4.dp
internal val spaceBetweenTitleAndYear = 4.dp

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(movie = Movie(
        id = "id",
        imagePath = "image",
        title = "title",
        year = "2023",
        rating = "8"
    ))
}

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(itemWidth)
    ) {
        Poster(path = movie.imagePath, rating = movie.rating, modifier = modifier)
        Spacer(modifier = modifier.size(spaceBetweenImageAndTitle))
        Title(title = movie.title, modifier = modifier)
        Spacer(modifier = modifier.size(spaceBetweenTitleAndYear))
        Year(year = movie.year, modifier = modifier)
    }
}

@Composable
fun Poster(
    path: String,
    rating: String?,
    modifier: Modifier = Modifier
) {
    Box {
        Image(path = path, modifier = modifier)
        rating?.let {
            Rating(rating = rating, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun Rating(
    rating: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "${stringResource(id = R.string.imdb)} $rating",
                modifier = Modifier
                    .background(color = YellowRipeLemon)
                    .padding(horizontal = 8.dp, vertical = 3.dp),
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun Image(
    path: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .height(itemHeight),
        shape = Shapes.large,
        elevation = 8.dp
    ) {
        AsyncImage(
            model = path,
            contentDescription = null,
            modifier = modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Title(
    title: String,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            "\n",
            textAlign = TextAlign.Center,
        )
        Text(
            text = title,
            modifier = modifier.fillMaxWidth(),
            color = Color.White,
            fontSize = 16.sp,
            maxLines = 2,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun Year(
    year: String?,
    modifier: Modifier
) {
    year?.let {
        Text(
            text = year,
            modifier = modifier.fillMaxWidth(),
            color = Color.LightGray,
            fontSize = 12.sp,
            maxLines = 1,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun MovieItemLoaderPreview() {
    MovieItemLoader()
}

@Composable
fun MovieItemLoader(
    modifier: Modifier = Modifier
) {
    Column {
        Box(modifier = modifier
            .width(itemWidth)
            .height(itemHeight)
            .shimmerBackground(Shapes.large)
        )
        Spacer(modifier = modifier.size(spaceBetweenImageAndTitle))
        Box(modifier = modifier
            .width(itemWidth / 4 * 3)
            .height(16.dp)
            .shimmerBackground(Shapes.small)
        )
        Spacer(modifier = modifier.size(spaceBetweenTitleAndYear))
        Box(modifier = modifier
            .width(itemWidth / 3)
            .height(12.dp)
            .shimmerBackground(Shapes.small)
        )
    }
}