package com.mldz.feature_main_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/mldz/feature_main_impl/di/MainFeatureDependencies;", "Lcom/mldz/module_injector/BaseDependencies;", "httpClient", "Lcom/mldz/core_network_api/data/HttpClient;", "feature_main_impl_debug"})
public abstract interface MainFeatureDependencies extends com.mldz.module_injector.BaseDependencies {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mldz.core_network_api.data.HttpClient httpClient();
}