package com.mldz.movieapp.framework.remote.model

import com.google.gson.annotations.SerializedName
import com.mldz.core.domain.Movie


data class MovieList(
    @SerializedName("page"          ) var page         : Int?               = null,
    @SerializedName("results"       ) var results      : List<MovieListItem> = arrayListOf(),
    @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
    @SerializedName("total_results" ) var totalResults : Int?               = null
)

data class MovieListItem (
    @SerializedName("adult"             ) var adult            : Boolean       = false,
    @SerializedName("backdrop_path"     ) var backdropPath     : String        = "",
    @SerializedName("genre_ids"         ) var genreIds         : List<Int> = arrayListOf(),
    @SerializedName("id"                ) var id               : Int            = 0,
    @SerializedName("original_language" ) var originalLanguage : String        = "",
    @SerializedName("original_title"    ) var originalTitle    : String        = "",
    @SerializedName("overview"          ) var overview         : String        = "",
    @SerializedName("popularity"        ) var popularity       : Double        = 0.0,
    @SerializedName("poster_path"       ) var posterPath       : String        = "",
    @SerializedName("release_date"      ) var releaseDate      : String        = "",
    @SerializedName("title"             ) var title            : String        = "",
    @SerializedName("video"             ) var video            : Boolean       = false,
    @SerializedName("vote_average"      ) var voteAverage      : Double        = 0.0,
    @SerializedName("vote_count"        ) var voteCount        : Int           = 0
)
