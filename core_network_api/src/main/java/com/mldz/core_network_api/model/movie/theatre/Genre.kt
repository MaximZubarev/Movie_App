package com.mldz.core_network_api.model.movie.theatre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    @SerialName("key")
    val key: String,
    @SerialName("value")
    val value: String
)