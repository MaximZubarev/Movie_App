package com.mldz.movieapp.utils

import com.mldz.core.domain.Movie
import com.mldz.core.domain.MovieDetails
import com.mldz.movieapp.framework.local.entity.MovieEntity
import com.mldz.movieapp.framework.remote.model.MovieListItem


fun MovieListItem.toMovie(): Movie = Movie(
    id = this.id.toLong(),
    title = this.title,
    image = this.posterPath,
    reviewsCount = this.voteCount,
    rating = this.voteAverage,
    isFavorite = false,
    genres = ArrayList()
)

fun com.mldz.movieapp.framework.remote.model.Movie.toMovieDetails(): MovieDetails = MovieDetails(
    id = this.id.toLong(),
    title = this.title,
    image = this.posterPath,
    reviewsCount = this.voteCount,
    rating = this.voteAverage,
    isFavorite = false,
    genres = ArrayList(),
    story = this.overview
)

fun MovieEntity.toMovie(): Movie = Movie(
    id = this.id,
    title = this.title,
    image = this.image,
    reviewsCount = this.reviewsCount,
    rating = this.rating,
    isFavorite = this.isFavorite,
    genres = listOf()
)

fun MovieEntity.toMovieDetails(): MovieDetails = MovieDetails(
    id = this.id,
    title = this.title,
    image = this.image,
    reviewsCount = this.reviewsCount,
    rating = this.rating,
    isFavorite = this.isFavorite,
    genres = listOf(),
    story = this.story
)