package com.mldz.data2.mappers

import com.mldz.core.entities.Movie
import com.mldz.core.entities.MovieDetails
import com.mldz.data2.entities.MovieEntity


class MovieEntityMapper {
    fun toMovieEntity(movie: Movie): MovieEntity {
        return MovieEntity(
            id = movie.id,
            title = movie.title,
            image = movie.image,
            reviewsCount = movie.reviewsCount,
            rating = movie.rating,
            isFavorite = movie.isFavorite,
        )
    }

    fun toMovie(movieEntity: MovieEntity): Movie {
        return Movie(
            id = movieEntity.id,
            title = movieEntity.title,
            image = movieEntity.image,
            reviewsCount = movieEntity.reviewsCount,
            rating = movieEntity.rating,
            isFavorite = movieEntity.isFavorite,
            genres = listOf()
        )
    }

    fun toMovieEntity(movie: MovieDetails): MovieEntity {
        return MovieEntity(
            id = movie.id,
            title = movie.title,
            image = movie.image,
            reviewsCount = movie.imDbRatingVotes,
            rating = movie.imDbRating,
            fullTitle = movie.fullTitle,
            type = movie.type,
            year = movie.year,
            releaseDate = movie.releaseDate,
            runtimeMins = movie.runtimeMins,
            runtimeStr = movie.runtimeStr,
            plot = movie.plot,
            plotLocal = movie.plotLocal,
            plotLocalIsRtl = movie.plotLocalIsRtl,
            awards = movie.awards,
            directors = movie.directors,
            writers = movie.writers,
            stars = movie.stars,
            fullCast = movie.fullCast.let { "" },
            genres = movie.genres,
            companies = movie.companies,
            countries = movie.countries,
            languages = movie.languages,
            contentRating = movie.contentRating,
            metacriticRating = movie.metacriticRating,
            ratings = movie.ratings.let { "" },
            wikipedia = movie.wikipedia.let { "" },
            posters = movie.posters.let { "" },
            images = movie.images.let { "" },
            trailer = movie.trailer.let { "" },
            tagline = movie.tagline,
            isFavorite = false
        )
    }

    fun toMovieDetails(movieEntity: MovieEntity): MovieDetails {
        return MovieDetails(
            id = movieEntity.id,
            title = movieEntity.title,
            image = movieEntity.image,
            imDbRatingVotes = movieEntity.reviewsCount,
            imDbRating = movieEntity.rating,
            fullTitle = movieEntity.fullTitle,
            type = movieEntity.type,
            year = movieEntity.year,
            releaseDate = movieEntity.releaseDate,
            runtimeMins = movieEntity.runtimeMins,
            runtimeStr = movieEntity.runtimeStr,
            plot = movieEntity.plot,
            plotLocal = movieEntity.plotLocal,
            plotLocalIsRtl = movieEntity.plotLocalIsRtl,
            awards = movieEntity.awards,
            directors = movieEntity.directors,
            writers = movieEntity.writers,
            stars = movieEntity.stars,
            fullCast = movieEntity.fullCast,
            genres = movieEntity.genres,
            companies = movieEntity.companies,
            countries = movieEntity.countries,
            languages = movieEntity.languages,
            contentRating = movieEntity.contentRating,
            metacriticRating = movieEntity.metacriticRating,
            ratings = movieEntity.ratings,
            wikipedia = movieEntity.wikipedia,
            posters = movieEntity.posters,
            images = movieEntity.images,
            trailer = movieEntity.trailer,
            tagline = movieEntity.tagline,
        )
    }
}