package com.mldz.feature_main_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/mldz/feature_main_impl/di/MainFeatureComponent;", "Lcom/mldz/feature_main_api/MainFeatureApi;", "getViewModel", "Lcom/mldz/feature_main_impl/presentation/MainViewModel;", "Companion", "feature_main_impl_debug"})
@com.mldz.core_utils.di.general.PerFeature()
@dagger.Component(modules = {com.mldz.feature_main_impl.di.MainFeatureModule.class}, dependencies = {com.mldz.feature_main_impl.di.MainFeatureDependencies.class})
public abstract interface MainFeatureComponent extends com.mldz.feature_main_api.MainFeatureApi {
    @org.jetbrains.annotations.NotNull()
    public static final com.mldz.feature_main_impl.di.MainFeatureComponent.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mldz.feature_main_impl.presentation.MainViewModel getViewModel();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mldz/feature_main_impl/di/MainFeatureComponent$Companion;", "", "()V", "initAndGet", "Lcom/mldz/feature_main_impl/di/MainFeatureComponent;", "dependencies", "Lcom/mldz/feature_main_impl/di/MainFeatureDependencies;", "feature_main_impl_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.mldz.feature_main_impl.di.MainFeatureComponent initAndGet(@org.jetbrains.annotations.NotNull()
        com.mldz.feature_main_impl.di.MainFeatureDependencies dependencies) {
            return null;
        }
    }
}