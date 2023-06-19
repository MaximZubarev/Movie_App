package com.mldz.core_network_api.model.movie.theatre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InTheatreData(
    @SerialName("errorMessage")
    val errorMessage: String,
    @SerialName("items")
    val items: List<Item>
)