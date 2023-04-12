package com.mldz.movieapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mldz.movieapp.models.Movie
import com.mldz.movieapp.models.MovieMenuItem
import com.mldz.movieapp.ui.*
import com.mldz.movieapp.utils.NavigationItem


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            TransparentSystemBars()
            MovieAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(BlueSanJuan, PurpleEastBay)
                            )
                        )
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        },
                        backgroundColor = Color.Transparent
                    ) {
                        Box(
                            modifier = Modifier.padding(it)
                        ) {
                            Navigation(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false,
            isNavigationBarContrastEnforced = false,
            transformColorForLightContent = { original ->
                Color.Black
            }
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val menu = listOf(
        NavigationItem.Main,
        NavigationItem.Favorites,
        NavigationItem.Settings
    )
    Divider (
        color = White20,
        modifier = Modifier
            .height(1.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    )
    BottomNavigation(
        modifier = Modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(PurpleScampi30, BlueAquamarine30)
                )
            )
            .navigationBarsPadding(),
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        menu.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = screen.iconId), contentDescription = null) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
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

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Main.route
    ) {
        composable(NavigationItem.Main.route) {
            MainScreen(popular, moviesMenu, upcoming)
        }
        composable(NavigationItem.Favorites.route) {
            FavoritesScreen()
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen()
        }
    }
}