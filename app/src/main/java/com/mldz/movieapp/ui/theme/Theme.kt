package com.mldz.movieapp.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mldz.movieapp.ui.theme.beVietnamProFamily


@Composable
fun MovieAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        shapes = Shapes,
        content = content,
        typography = Typography(defaultFontFamily = beVietnamProFamily)
    )
}

private val LightColors = lightColors(
    surface = BlackCinder,
    onSurface = Color.White,
    background = BlackCinder,
    onBackground = Color.White
)