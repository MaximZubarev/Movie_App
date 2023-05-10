package com.mldz.feature_main_impl.presentation.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mldz.core_design.R
import com.mldz.feature_main_impl.models.Movie
import com.mldz.feature_main_impl.presentation.MainViewModel
import com.mldz.feature_main_impl.presentation.PopularMoviesState
import com.mldz.movieapp.models.MovieMenuItem
import com.mldz.movieapp.ui.*


@Composable
fun MainScreen(
    viewModel: MainViewModel,
    moviesMenu: List<MovieMenuItem>
) {
//    val uiState = viewModel.uiState.collectAsState()
//    Column(
//        modifier = Modifier
//            .verticalScroll(rememberScrollState())
//            .systemBarsPadding()
//    ) {
//        TopBar()
//        Popular(popularMoviesState = uiState.value.popularMoviesState)
//        Spacer(modifier = Modifier.height(45.dp))
//        MoviesMenu(moviesMenu = moviesMenu)
//        Spacer(modifier = Modifier.size(35.dp))
////        UpComing(upcomingReleases = upcomnigReleases)
//    }
}

@Composable
fun TopBar() {
    Column(
        modifier = Modifier.padding(
            start = 50.dp,
            top = 50.dp,
            end = 50.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(
                start = 14.dp,
                end = 14.dp
            )
        ) {
            Greeting(
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_notfication),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
        Search(modifier = Modifier.padding(top = 21.dp))
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.greeting_title),
        fontSize = 18.sp,
        color = Color.White,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )
}

@Composable
fun Search(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = stringResource(id = R.string.search)) },
        modifier = modifier.fillMaxWidth(),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = ""
            )
        },
        textStyle = TextStyle(color = White05, fontWeight = FontWeight.Normal),
        singleLine = true,
        maxLines = 1,
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.White.copy(alpha = 0.2f),
            focusedLabelColor = White05,
        )
    )
}

@Composable
fun Popular(
    popularMoviesState: PopularMoviesState,
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
            modifier = Modifier.padding(start = 50.dp)
        )
        when(popularMoviesState) {
            is PopularMoviesState.Error -> {}
            is PopularMoviesState.Loading -> {}
            is PopularMoviesState.Success -> {
                LazyRow(
                    modifier = Modifier.padding(top = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(horizontal = 50.dp)
                ) {
                    items(popularMoviesState.movies) { movie -> MoviePopularItem(movie = movie) }
                }
            }
        }
    }
}

@Composable
fun MoviePopularItem(movie: Movie) {
    Card(
        modifier = Modifier
            .width(320.dp)
            .height(140.dp),
        shape = RoundedCornerShape(30.dp),
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

@Preview
@Composable
fun MoviesMenuPreview() {
    MoviesMenu(
        moviesMenu = listOf(
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
    )
}

@Composable
fun MoviesMenu(
    moviesMenu: List<MovieMenuItem>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 45.dp, end = 28.dp)
    ) {
        moviesMenu.forEach {
            MovieMenuCard(movie = it)
            Spacer(modifier = Modifier.size(17.dp))
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

@Composable
fun UpComing(
    upcomingReleases: List<Movie>
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
            items(upcomingReleases) { movie -> UpComingItem(movie = movie) }
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