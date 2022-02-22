package com.mldz.movieapp.utils

import com.mldz.core.domain.Movie
import com.mldz.core.domain.MovieDetails
import com.mldz.movieapp.framework.remote.model.MovieListItem


fun MovieListItem.toMovieDetails(): Movie {
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

fun com.mldz.movieapp.framework.remote.model.Movie.toMovieDetails(): MovieDetails {
    return MovieDetails(
        id = this.id.toLong(),
        title = this.title,
        image = this.posterPath,
        reviewsCount = this.voteCount,
        rating = this.voteAverage,
        isFavorite = false,
        genres = ArrayList(),
        story = this.overview
    )
}