package com.mldz.feature_main_impl.models


data class Movie(
    val id: String,
    val imagePath: String,
    val title: String,
    val year: String? = null,
    val rating: String? = null
)
