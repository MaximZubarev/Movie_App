package com.mldz.core_network_api.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MostPopularDataDetail(
    @SerialName("crew")
    val crew: String,
    @SerialName("fullTitle")
    val fullTitle: String,
    @SerialName("id")
    val id: String,
    @SerialName("imDbRating")
    val imDbRating: String,
    @SerialName("imDbRatingCount")
    val imDbRatingCount: String,
    @SerialName("image")
    val image: String,
    @SerialName("rank")
    val rank: String,
    @SerialName("rankUpDown")
    val rankUpDown: String,
    @SerialName("title")
    val title: String,
    @SerialName("year")
    val year: String
)