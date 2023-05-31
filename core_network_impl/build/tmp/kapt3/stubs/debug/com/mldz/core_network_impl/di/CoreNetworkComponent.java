package com.mldz.core_network_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/mldz/core_network_impl/di/CoreNetworkComponent;", "Lcom/mldz/core_network_api/di/CoreNetworkApi;", "()V", "Companion", "core_network_impl_debug"})
@dagger.Component(modules = {com.mldz.core_network_impl.di.NetworkModule.class, com.mldz.core_network_impl.di.RetrofitModule.class})
@javax.inject.Singleton()
public abstract class CoreNetworkComponent implements com.mldz.core_network_api.di.CoreNetworkApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.mldz.core_network_impl.di.CoreNetworkComponent.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.mldz.core_network_impl.di.CoreNetworkComponent component;
    
    public CoreNetworkComponent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/mldz/core_network_impl/di/CoreNetworkComponent$Companion;", "", "()V", "component", "Lcom/mldz/core_network_impl/di/CoreNetworkComponent;", "get", "core_network_impl_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mldz.core_network_impl.di.CoreNetworkComponent get() {
            return null;
        }
    }
}