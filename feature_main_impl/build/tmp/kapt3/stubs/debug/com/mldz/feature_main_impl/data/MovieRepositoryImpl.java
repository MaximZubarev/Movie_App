package com.mldz.feature_main_impl.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/mldz/feature_main_impl/data/MovieRepositoryImpl;", "Lcom/mldz/feature_main_impl/domain/MovieRepository;", "httpClient", "Lcom/mldz/core_network_api/data/HttpClient;", "(Lcom/mldz/core_network_api/data/HttpClient;)V", "getComingSoonMovies", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/mldz/feature_main_impl/models/Movie;", "getPopularMovies", "feature_main_impl_debug"})
@com.mldz.core_utils.di.general.PerFeature()
public final class MovieRepositoryImpl implements com.mldz.feature_main_impl.domain.MovieRepository {
    private final com.mldz.core_network_api.data.HttpClient httpClient = null;
    
    @javax.inject.Inject()
    public MovieRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.mldz.core_network_api.data.HttpClient httpClient) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mldz.feature_main_impl.models.Movie>> getPopularMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.mldz.feature_main_impl.models.Movie>> getComingSoonMovies() {
        return null;
    }
}