package com.mldz.core_network_impl.di

import com.mldz.core_network_api.di.CoreNetworkApi
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, RetrofitModule::class])
abstract class CoreNetworkComponent: CoreNetworkApi {

    companion object {
        @Volatile
        private var component: CoreNetworkComponent? = null

        fun get(): CoreNetworkComponent {
            if (component == null) {
                synchronized(CoreNetworkComponent::class.java) {
                    if (component == null) {
//                        component = DaggerCoreNetworkComponent.builder().build()
                    }
                }
            }
            return component!!
        }
    }
}