package com.mldz.feature_main_api

import com.mldz.module_injector.BaseApi


interface MainFeatureApi: BaseApi {

    fun mainScreen(): MainScreenStarter
}