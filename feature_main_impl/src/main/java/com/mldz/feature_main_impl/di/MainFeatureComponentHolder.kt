package com.mldz.feature_main_impl.di

import com.mldz.feature_main_api.MainFeatureApi
import com.mldz.module_injector.ComponentHolder


object MainFeatureComponentHolder: ComponentHolder<MainFeatureApi, MainFeatureDependencies> {

    private var componentHolder: MainFeatureComponent? = null

    override fun init(dependencies: MainFeatureDependencies) {
        if (componentHolder == null) {
            synchronized(MainFeatureComponentHolder::class) {
                if (componentHolder == null) {
                    componentHolder = MainFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): MainFeatureApi = getComponent()

    internal fun getComponent(): MainFeatureComponent {
        checkNotNull(componentHolder) {
            "MainFeatureComponent was not initialized!"
        }
        return componentHolder!!
    }

    override fun reset() {
        componentHolder = null
    }

}