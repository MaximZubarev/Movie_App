package com.mldz.movieapp.di.modules

import com.mldz.data2.api.ApiServiceImdb
import com.mldz.data2.db.MovieDao
import com.mldz.data2.mappers.MovieApiMapper
import com.mldz.data2.mappers.MovieEntityMapper
import com.mldz.data2.repositories.movie.MovieLocalDataSource
import com.mldz.data2.repositories.movie.MovieLocalDataSourceImpl
import com.mldz.data2.repositories.movie.MovieRemoteDataSource
import com.mldz.data2.repositories.movie.MovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun provideDispatcherIO (): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    fun provideMovieRemoteDataSource(
        apiServiceImdb: ApiServiceImdb,
        apiMapper: MovieApiMapper
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(apiServiceImdb, apiMapper)
    }

    @Provides
    fun provideMovieLocalDataSource(
        dao: MovieDao,
        dispatcher: CoroutineDispatcher,
        mapper: MovieEntityMapper
    ): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(dao, dispatcher, mapper)
    }
}