package com.mldz.core_network_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/mldz/core_network_impl/di/NetworkModule;", "", "()V", "provideHttpClient", "Lcom/mldz/core_network_api/data/HttpClient;", "httpClient", "Lcom/mldz/core_network_impl/data/HttpClientImpl;", "core_network_impl_debug"})
@dagger.Module()
public abstract class NetworkModule {
    
    public NetworkModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    @javax.inject.Singleton()
    public abstract com.mldz.core_network_api.data.HttpClient provideHttpClient(@org.jetbrains.annotations.NotNull()
    com.mldz.core_network_impl.data.HttpClientImpl httpClient);
}