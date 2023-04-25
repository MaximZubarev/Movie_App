package com.mldz.feature_main_impl.start

import androidx.navigation.compose.composable
import com.mldz.feature_main_api.MainScreen
import com.mldz.feature_main_impl.R
import com.mldz.movieapp.models.Movie
import com.mldz.movieapp.models.MovieMenuItem
import com.mldz.feature_main_impl.presentation.screen.MainScreen as Main
import javax.inject.Inject


class MainScreenImpl @Inject constructor(): MainScreen {

    private val baseRoute = "main"

    override fun mainRoute(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: androidx.navigation.NavGraphBuilder,
        navController: androidx.navigation.NavController,
        modifier: androidx.compose.ui.Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            Main(popular, moviesMenu, upcoming)
        }
    }

    val popular = listOf(
        Movie(
            "https://horrorzone.ru/uploads/_pages3/81465/d4fe66ebb9a9332e9374773f2b5be69dce5ecc44-16x9-x0y181w4488h2525.jpg",
            "Hollywood"
        ),
        Movie(
            "https://avatars.dzeninfra.ru/get-zen_doc/3957194/pub_603918766cd9133fa60cd8a3_60391a2949b4e72890296c67/scale_1200",
            "Captain Marvel"
        ),
        Movie(
            "https://million-wallpapers.ru/wallpapers/5/51/474956579126368/avatar-chelovek-portret-zakat.jpg",
            "Avatar"
        )
    )
    val moviesMenu = listOf(
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
    val upcoming = listOf(
        Movie(
            "https://cdn1.ntv.com.tr/gorsel/sbEj0EPAV0yjUZLGhTmnWg.jpg?width=1000&mode=both&scale=both&v=1483955200842",
            "Hollywood"
        ),
        Movie(
            "https://i.pinimg.com/originals/2e/a3/04/2ea304188d45b3c7157e1c1124f29255.jpg",
            "Captain Marvel"
        ),
        Movie(
            "https://www.film.ru/sites/default/files/movies/posters/49637923-1743567.jpg",
            "Avatar"
        ),
        Movie(
            "https://i.pinimg.com/736x/7e/17/ae/7e17aea80fb28af21e56743642a25fb5.jpg",
            "Avatar"
        )
    )
}