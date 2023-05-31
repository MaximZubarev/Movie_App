package com.mldz.core_network_impl.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/mldz/core_network_impl/data/HttpClientImpl;", "Lcom/mldz/core_network_api/data/HttpClient;", "api", "Lcom/mldz/core_network_impl/retrofit/MovieApi;", "(Lcom/mldz/core_network_impl/retrofit/MovieApi;)V", "getComingSoonMovies", "Lcom/mldz/core_network_api/model/ComingSoonData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopularMovies", "Lcom/mldz/core_network_api/model/MostPopularData;", "core_network_impl_debug"})
public final class HttpClientImpl implements com.mldz.core_network_api.data.HttpClient {
    private final com.mldz.core_network_impl.retrofit.MovieApi api = null;
    
    @javax.inject.Inject()
    public HttpClientImpl(@org.jetbrains.annotations.NotNull()
    com.mldz.core_network_impl.retrofit.MovieApi api) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getPopularMovies(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mldz.core_network_api.model.MostPopularData> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getComingSoonMovies(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mldz.core_network_api.model.ComingSoonData> continuation) {
        return null;
    }
}