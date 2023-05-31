package com.mldz.feature_main_impl.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/mldz/feature_main_impl/presentation/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "movieRepository", "Lcom/mldz/feature_main_impl/domain/MovieRepository;", "(Lcom/mldz/feature_main_impl/domain/MovieRepository;)V", "comingSoonMovies", "Lkotlinx/coroutines/flow/Flow;", "Lcom/mldz/core_utils/di/general/Result;", "", "Lcom/mldz/feature_main_impl/models/Movie;", "popularMovies", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/mldz/feature_main_impl/presentation/MainScreenUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "feature_main_impl_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.flow.Flow<com.mldz.core_utils.di.general.Result<java.util.List<com.mldz.feature_main_impl.models.Movie>>> popularMovies = null;
    private final kotlinx.coroutines.flow.Flow<com.mldz.core_utils.di.general.Result<java.util.List<com.mldz.feature_main_impl.models.Movie>>> comingSoonMovies = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.mldz.feature_main_impl.presentation.MainScreenUiState> uiState = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.mldz.feature_main_impl.domain.MovieRepository movieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.mldz.feature_main_impl.presentation.MainScreenUiState> getUiState() {
        return null;
    }
}