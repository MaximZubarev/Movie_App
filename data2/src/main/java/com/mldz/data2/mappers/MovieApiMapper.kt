package com.mldz.data2.mappers

import com.mldz.core.entities.Movie
import com.mldz.core.entities.MovieDetails
import com.mldz.data2.api.model.Item
import com.mldz.data2.api.model.MovieResponse


class MovieApiMapper {
    fun toMovie(movieResponse: Item): Movie {
        return Movie(
            id = movieResponse.id,
            title = movieResponse.title,
            image = movieResponse.image,
            reviewsCount = movieResponse.imDBRatingCount,
            rating = movieResponse.imDBRating,
            isFavorite = false,
            genres = listOf()
        )
    }

    fun toMovie(movieResponse: MovieResponse): Movie {
        return Movie(
            id = movieResponse.id,
            title = movieResponse.title,
            image = movieResponse.image,
            reviewsCount = movieResponse.imDbRatingVotes,
            rating = movieResponse.imDbRating,
            isFavorite = false,
            genres = listOf()
        )
    }
    
    fun toMovieDetails(movie: MovieResponse): MovieDetails {
        return MovieDetails(
            id = movie.id,
            title = movie.title,
            image = movie.image,
            imDbRatingVotes = movie.imDbRatingVotes,
            imDbRating = movie.imDbRating,
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
            ratings = movie.ratings,
            wikipedia = movie.wikipedia,
            posters = movie.posters,
            images = movie.images,
            trailer = movie.trailer,
            tagline = movie.tagline.let { "" },
        )
    }
}