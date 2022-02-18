package com.mldz.movieapp.framework.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Configuration(
    @SerializedName("images"      ) var images     : Images?           = Images(),
    @SerializedName("change_keys" ) var changeKeys : List<String> = arrayListOf()
)

@Serializable
data class Images(
    @SerializedName("base_url"        ) var baseUrl       : String?           = null,
    @SerializedName("secure_base_url" ) var secureBaseUrl : String?           = null,
    @SerializedName("backdrop_sizes"  ) var backdropSizes : ArrayList<String> = arrayListOf(),
    @SerializedName("logo_sizes"      ) var logoSizes     : ArrayList<String> = arrayListOf(),
    @SerializedName("poster_sizes"    ) var posterSizes   : ArrayList<String> = arrayListOf(),
    @SerializedName("profile_sizes"   ) var profileSizes  : ArrayList<String> = arrayListOf(),
    @SerializedName("still_sizes"     ) var stillSizes    : ArrayList<String> = arrayListOf()
)