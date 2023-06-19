package com.mldz.core_network_api.model.movie.theatre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Director(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String
)