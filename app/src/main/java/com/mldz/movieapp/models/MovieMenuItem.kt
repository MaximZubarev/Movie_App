package com.mldz.movieapp.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class MovieMenuItem(
    val id: Int,
    @DrawableRes val image: Int,
    @StringRes val title: Int
)
