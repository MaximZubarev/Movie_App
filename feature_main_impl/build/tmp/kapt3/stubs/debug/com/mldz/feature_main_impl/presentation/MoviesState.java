package com.mldz.feature_main_impl.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/mldz/feature_main_impl/presentation/MoviesState;", "", "Error", "Loading", "Success", "Lcom/mldz/feature_main_impl/presentation/MoviesState$Error;", "Lcom/mldz/feature_main_impl/presentation/MoviesState$Loading;", "Lcom/mldz/feature_main_impl/presentation/MoviesState$Success;", "feature_main_impl_debug"})
public abstract interface MoviesState {
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/mldz/feature_main_impl/presentation/MoviesState$Success;", "Lcom/mldz/feature_main_impl/presentation/MoviesState;", "movies", "", "Lcom/mldz/feature_main_impl/models/Movie;", "(Ljava/util/List;)V", "getMovies", "()Ljava/util/List;", "feature_main_impl_debug"})
    public static final class Success implements com.mldz.feature_main_impl.presentation.MoviesState {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.mldz.feature_main_impl.models.Movie> movies = null;
        
        public Success(@org.jetbrains.annotations.NotNull()
        java.util.List<com.mldz.feature_main_impl.models.Movie> movies) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.mldz.feature_main_impl.models.Movie> getMovies() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/mldz/feature_main_impl/presentation/MoviesState$Error;", "Lcom/mldz/feature_main_impl/presentation/MoviesState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "feature_main_impl_debug"})
    public static final class Error implements com.mldz.feature_main_impl.presentation.MoviesState {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/mldz/feature_main_impl/presentation/MoviesState$Loading;", "Lcom/mldz/feature_main_impl/presentation/MoviesState;", "()V", "feature_main_impl_debug"})
    public static final class Loading implements com.mldz.feature_main_impl.presentation.MoviesState {
        @org.jetbrains.annotations.NotNull()
        public static final com.mldz.feature_main_impl.presentation.MoviesState.Loading INSTANCE = null;
        
        private Loading() {
            super();
        }
    }
}