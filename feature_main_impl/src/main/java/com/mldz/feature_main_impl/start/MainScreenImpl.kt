package com.mldz.feature_main_impl.start

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mldz.core_utils.di.general.injectedViewModel
import com.mldz.feature_main_api.MainScreenStarter
import com.mldz.feature_main_impl.di.MainFeatureComponentHolder
import com.mldz.feature_main_impl.presentation.screen.MainScreen
import javax.inject.Inject


class MainScreenImpl @Inject constructor() : MainScreenStarter {

    private val baseRoute = "main"

    override fun mainRoute(): String = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            val viewModel = injectedViewModel {
                MainFeatureComponentHolder.getComponent().getViewModel()
            }
            MainScreen(
                viewModel = viewModel,
            )
        }
    }
}