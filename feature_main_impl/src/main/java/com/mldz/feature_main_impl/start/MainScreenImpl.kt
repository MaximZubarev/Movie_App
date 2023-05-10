package com.mldz.feature_main_impl.start

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mldz.core_utils.di.general.daggerViewModel
import com.mldz.feature_main_api.MainScreenStarter
import com.mldz.feature_main_impl.R
import com.mldz.feature_main_impl.data.MovieRepositoryImpl
import com.mldz.feature_main_impl.di.DaggerMainFeatureComponent
import com.mldz.feature_main_impl.di.MainFeatureComponent
import com.mldz.feature_main_impl.di.MainFeatureComponentHolder
import com.mldz.feature_main_impl.models.Movie
import com.mldz.feature_main_impl.presentation.MainViewModel
import com.mldz.movieapp.models.MovieMenuItem
import com.mldz.feature_main_impl.presentation.screen.MainScreen
import javax.inject.Inject


class MainScreenImpl @Inject constructor(): MainScreenStarter {

    private val baseRoute = "main"

    override fun mainRoute(): String = baseRoute

    val component = MainFeatureComponentHolder.getComponent()

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {

        navGraphBuilder.composable(baseRoute) {
            val viewModel: MainViewModel = rememberViewModel()

//            val viewModel = component.getMainViewModel()
//            val viewModel = daggerViewModel {
//                component.getMainViewModel()
//            }
//            MainScreen(
//                viewModel = viewModel,
//                moviesMenu = moviesMenu
//            )
        }
    }

//    val popular = listOf(
//        Movie(
//            "https://horrorzone.ru/uploads/_pages3/81465/d4fe66ebb9a9332e9374773f2b5be69dce5ecc44-16x9-x0y181w4488h2525.jpg",
//            "Hollywood"
//        ),
//        Movie(
//            "https://avatars.dzeninfra.ru/get-zen_doc/3957194/pub_603918766cd9133fa60cd8a3_60391a2949b4e72890296c67/scale_1200",
//            "Captain Marvel"
//        ),
//        Movie(
//            "https://million-wallpapers.ru/wallpapers/5/51/474956579126368/avatar-chelovek-portret-zakat.jpg",
//            "Avatar"
//        )
//    )
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
//    val upcoming = listOf(
//        Movie(
//            "https://cdn1.ntv.com.tr/gorsel/sbEj0EPAV0yjUZLGhTmnWg.jpg?width=1000&mode=both&scale=both&v=1483955200842",
//            "Hollywood"
//        ),
//        Movie(
//            "https://i.pinimg.com/originals/2e/a3/04/2ea304188d45b3c7157e1c1124f29255.jpg",
//            "Captain Marvel"
//        ),
//        Movie(
//            "https://www.film.ru/sites/default/files/movies/posters/49637923-1743567.jpg",
//            "Avatar"
//        ),
//        Movie(
//            "https://i.pinimg.com/736x/7e/17/ae/7e17aea80fb28af21e56743642a25fb5.jpg",
//            "Avatar"
//        )
//    )
}