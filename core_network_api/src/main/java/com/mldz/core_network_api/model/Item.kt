package com.mldz.core_network_api.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    @SerialName("fullTitle")
    val fullTitle: String,
    @SerialName("genres")
    val genres: String,
    @SerialName("id")
    val id: String,
    @SerialName("image")
    val image: String,
    @SerialName("title")
    val title: String,
    @SerialName("year")
    val year: String
)