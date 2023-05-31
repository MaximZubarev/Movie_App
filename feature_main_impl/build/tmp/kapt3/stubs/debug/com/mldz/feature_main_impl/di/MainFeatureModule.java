package com.mldz.feature_main_impl.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/mldz/feature_main_impl/di/MainFeatureModule;", "", "()V", "provideMainScreen", "Lcom/mldz/feature_main_api/MainScreenStarter;", "mainScreenImpl", "Lcom/mldz/feature_main_impl/start/MainScreenImpl;", "provideMovieRepository", "Lcom/mldz/feature_main_impl/domain/MovieRepository;", "movieRepositoryImpl", "Lcom/mldz/feature_main_impl/data/MovieRepositoryImpl;", "feature_main_impl_debug"})
@dagger.Module()
public abstract class MainFeatureModule {
    
    public MainFeatureModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    @com.mldz.core_utils.di.general.PerFeature()
    public abstract com.mldz.feature_main_api.MainScreenStarter provideMainScreen(@org.jetbrains.annotations.NotNull()
    com.mldz.feature_main_impl.start.MainScreenImpl mainScreenImpl);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    @com.mldz.core_utils.di.general.PerFeature()
    public abstract com.mldz.feature_main_impl.domain.MovieRepository provideMovieRepository(@org.jetbrains.annotations.NotNull()
    com.mldz.feature_main_impl.data.MovieRepositoryImpl movieRepositoryImpl);
}