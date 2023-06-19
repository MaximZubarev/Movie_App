package com.mldz.core_network_api.model.movie.top


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Top250Data(
    @SerialName("errorMessage")
    val errorMessage: String,
    @SerialName("items")
    val items: List<Item>
)