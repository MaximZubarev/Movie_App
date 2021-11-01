package com.mldz.movieapp.models

import androidx.annotation.DrawableRes
import java.io.Serializable


data class ActorData(
        val id: Int,
        val name: String,
        @DrawableRes
        val imageRes: Int
): Serializable
