package com.mldz.feature_main_api

import com.mldz.feature_api.FeatureApi


interface MainScreen: FeatureApi {

    fun mainRoute(): String
}