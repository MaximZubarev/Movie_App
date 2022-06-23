package com.mldz.data2.api.model

import com.google.gson.annotations.SerializedName


data class GenreResponse(
    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null
)
