package com.mldz.feature_main_impl.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/mldz/feature_main_impl/domain/MovieRepository;", "", "getComingSoonMovies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mldz/feature_main_impl/models/Movie;", "getPopularMovies", "feature_main_impl_debug"})
public abstract interface MovieRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mldz.feature_main_impl.models.Movie>> getPopularMovies();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.mldz.feature_main_impl.models.Movie>> getComingSoonMovies();
}