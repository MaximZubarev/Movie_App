package com.mldz.feature_main_impl.data

import com.mldz.core_network_api.data.HttpClient
import com.mldz.feature_main_impl.domain.MovieRepository
import com.mldz.feature_main_impl.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    val httpClient: HttpClient
): MovieRepository {

    override fun getPopularMovies(): Flow<List<Movie>> {
        return flow {
            emit(httpClient.getPopularMovies().mostPopularDataDetails.map {
                Movie(it.id, it.image, it.title)
            })
        }
    }
}