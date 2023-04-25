package com.mldz.core_network_api.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MostPopularData(
    @SerialName("errorMessage")
    val errorMessage: String,
    @SerialName("items")
    val mostPopularDataDetails: List<MostPopularDataDetail>
)