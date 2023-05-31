package com.mldz.feature_main_impl.di

import com.mldz.core_utils.di.general.PerFeature
import com.mldz.feature_main_api.MainFeatureApi
import com.mldz.feature_main_impl.presentation.MainViewModel
import dagger.Component


@Component(
    modules = [
        MainFeatureModule::class
    ],
    dependencies = [MainFeatureDependencies::class]
)
@PerFeature
interface MainFeatureComponent : MainFeatureApi {

    fun getViewModel(): MainViewModel

    companion object {
        fun initAndGet(dependencies: MainFeatureDependencies): MainFeatureComponent {
            return DaggerMainFeatureComponent.builder()
                .mainFeatureDependencies(dependencies)
                .build()
        }
    }
}