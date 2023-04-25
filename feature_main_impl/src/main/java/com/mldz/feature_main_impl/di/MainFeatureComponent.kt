package com.mldz.feature_main_impl.di

import com.mldz.feature_main_api.MainFeatureApi
import com.mldz.core_utils.di.general.PerFeature
import dagger.Component


@Component(
    modules = [MainFeatureModule::class],
    dependencies = [MainFeatureDependencies::class]
)
@PerFeature
abstract class MainFeatureComponent: MainFeatureApi {

    companion object {
        fun initAndGet(dependencies: MainFeatureDependencies): MainFeatureComponent {
            return DaggerMainFeatureComponent.builder()
                .mainFeatureDependencies(dependencies)
                .build()
        }
    }
}