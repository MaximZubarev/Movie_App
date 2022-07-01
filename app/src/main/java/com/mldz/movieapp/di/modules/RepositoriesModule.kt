package com.mldz.movieapp.di.modules

import com.mldz.core.repositories.MovieRepository
import com.mldz.data2.repositories.movie.MovieLocalDataSource
import com.mldz.data2.repositories.movie.MovieRemoteDataSource
import com.mldz.data2.repositories.movie.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    fun provideMovieRepo(
        movieRemoteDataSourceImpl: MovieRemoteDataSource,
        movieLocalDataSourceImpl: MovieLocalDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSourceImpl, movieLocalDataSourceImpl)
    }
}