package com.mldz.movieapp.utils

import com.mldz.core.domain.Movie
import com.mldz.movieapp.framework.remote.model.MovieListItem


fun MovieListItem.toMovie(): Movie {
    return Movie(
        id = this.id.toLong(),
        title = this.title,
        image = this.posterPath,
        reviewsCount = this.voteCount,
        rating = this.voteAverage,
        isFavorite = false,
        genres = ArrayList()
    )
}

fun com.mldz.movieapp.framework.remote.model.Movie.toMovie(): Movie {
    return Movie(
        id = this.id.toLong(),
        title = this.title,
        image = this.posterPath,
        reviewsCount = this.voteCount,
        rating = this.voteAverage,
        isFavorite = false,
        genres = ArrayList()
    )
}