package com.mldz.core_network_impl.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007"}, d2 = {"Lcom/mldz/core_network_impl/retrofit/MovieApi;", "", "getComingSoon", "Lcom/mldz/core_network_api/model/ComingSoonData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPopular", "Lcom/mldz/core_network_api/model/MostPopularData;", "core_network_impl_debug"})
public abstract interface MovieApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/ru/API/MostPopularMovies")
    public abstract java.lang.Object getPopular(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mldz.core_network_api.model.MostPopularData> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/ru/API/ComingSoon")
    public abstract java.lang.Object getComingSoon(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.mldz.core_network_api.model.ComingSoonData> continuation);
}