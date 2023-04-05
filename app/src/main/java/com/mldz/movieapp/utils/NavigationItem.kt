package com.mldz.movieapp.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mldz.movieapp.R


sealed class NavigationItem(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int = 0
) {
    object Main: NavigationItem("main", R.string.menu_main, R.drawable.ic_main)
    object Movie: NavigationItem("movie", R.string.menu_movie)
    object Favorites: NavigationItem("favorites", R.string.menu_favorites, R.drawable.ic_outline_favorite_border_24)
    object Settings: NavigationItem("settings", R.string.menu_settings, R.drawable.outline_settings_24)
}