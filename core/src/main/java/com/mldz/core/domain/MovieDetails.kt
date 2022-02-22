package com.mldz.core.domain


data class MovieDetails(
    val id: Long,
    val title: String,
    val image: String,
    val reviewsCount: Int,
    val rating: Double,
    val isFavorite: Boolean,
    val genres: List<Genre>,
    val story: String
)