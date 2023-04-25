package com.mldz.movieapp.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.mldz.feature_api.FeatureApi


fun NavGraphBuilder.register(
    featureApi: FeatureApi,
    navController: NavController,
    modifier: Modifier
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}