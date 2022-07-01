package com.mldz.movieapp.di.modules

import com.mldz.core.repositories.MovieRepository
import com.mldz.core.usecases.FetchMovie
import com.mldz.core.usecases.FetchMovies
import com.mldz.core.usecases.GetMovie
import com.mldz.core.usecases.GetMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideGetMovies(repositoryImpl: MovieRepository): GetMovies {
        return GetMovies(repositoryImpl)
    }

    @Provides
    fun provideGetMovie(repositoryImpl: MovieRepository): GetMovie {
        return GetMovie(repositoryImpl)
    }

    @Provides
    fun provideFetchMovies(repositoryImpl: MovieRepository): FetchMovies {
        return FetchMovies(repositoryImpl)
    }

    @Provides
    fun provideFetchMovie(repositoryImpl: MovieRepository): FetchMovie {
        return FetchMovie(repositoryImpl)
    }
}