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
import com.mldz.core_design.theme.MovieAppTheme
import com.mldz.feature_main_api.MainFeatureApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mldz.core_design.theme.BlueAquamarine30
import com.mldz.core_design.theme.BlueSanJuan
import com.mldz.core_design.theme.PurpleEastBay
import com.mldz.core_design.theme.PurpleScampi30
import com.mldz.core_design.theme.White20
import com.mldz.movieapp.navigation.register
import com.mldz.movieapp.ui.*
import com.mldz.movieapp.utils.NavigationItem
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainFeatureApi: MainFeatureApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
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
                            Navigation(
                                navController = navController,
                                mainFeatureApi = mainFeatureApi
                            )
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

@Composable
fun Navigation(
    navController: NavHostController,
    mainFeatureApi: MainFeatureApi
) {
    NavHost(
        navController = navController,
        startDestination = mainFeatureApi.mainScreen().mainRoute()
    ) {
        register(
            featureApi = mainFeatureApi.mainScreen(),
            navController = navController,
            modifier = Modifier
        )
        composable(NavigationItem.Favorites.route) {
            FavoritesScreen()
        }
        composable(NavigationItem.Settings.route) {
            SettingsScreen()
        }
    }
}