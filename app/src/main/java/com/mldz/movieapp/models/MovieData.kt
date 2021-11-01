package com.mldz.movieapp.models
import java.io.Serializable


data class MovieData(
        val title: String,
        val rating: Int,
        val genre: String,
        val reviewsCount: Int,
        val duration: Int,
        val poster: Int,
        val isLiked: Boolean,
        val age: Int,
        val description: String,
        val actors: List<ActorData>
): Serializable
