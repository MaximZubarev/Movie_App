package com.mldz.data2.api.model

import com.google.gson.annotations.SerializedName


data class MovieListResponse (
    @SerializedName("items")
    val items: List<Item> = listOf(),
    @SerializedName("errorMessage")
    val errorMessage: String = ""
)

data class Item (
    @SerializedName("id")
    val id: String = "",
    @SerializedName("rank")
    val rank: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("fullTitle")
    val fullTitle: String = "",
    @SerializedName("year")
    val year: String = "",
    @SerializedName("image")
    val image: String = "",
    @SerializedName("crew")
    val crew: String = "",
    @SerializedName("imDbRating")
    val imDBRating: String = "",
    @SerializedName("imDbRatingCount")
    val imDBRatingCount: String = ""
)
