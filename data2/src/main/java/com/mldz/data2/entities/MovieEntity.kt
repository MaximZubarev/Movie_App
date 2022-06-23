package com.mldz.data2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    var id: String,
    var title: String = "",
    var fullTitle: String = "",
    var type: String = "",
    var year: String = "",
    var image: String = "",
    var releaseDate: String = "",
    var runtimeMins: String = "",
    var runtimeStr: String = "",
    var plot: String = "",
    var plotLocal: String = "",
    var plotLocalIsRtl: Boolean = false,
    var awards: String = "",
    var directors: String = "",
    var writers: String = "",
    var stars: String = "",
    var fullCast: String = "",
    var genres: String = "",
    var companies: String = "",
    var countries: String = "",
    var languages: String = "",
    var contentRating: String = "",
    var rating: String = "",
    var reviewsCount: String = "",
    var metacriticRating: String = "",
    var ratings: String = "",
    var wikipedia: String = "",
    var posters: String = "",
    var images: String = "",
    var trailer: String = "",
    var tagline: String = "",
    var errorMessage: String = "",

    val isFavorite: Boolean,
)