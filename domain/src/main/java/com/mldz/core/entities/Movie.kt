package com.mldz.core.entities


data class Movie(
    val id: String,
    val title: String,
    val image: String,
    val reviewsCount: String,
    val rating: String,
    val isFavorite: Boolean,
    val genres: List<Genre>
)
