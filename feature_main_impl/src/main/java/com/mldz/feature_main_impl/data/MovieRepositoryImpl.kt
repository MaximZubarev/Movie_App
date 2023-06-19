package com.mldz.feature_main_impl.data

import com.mldz.core_network_api.data.HttpClient
import com.mldz.core_utils.di.general.PerFeature
import com.mldz.feature_main_impl.domain.MovieRepository
import com.mldz.feature_main_impl.models.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


@PerFeature
class MovieRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
): MovieRepository {

    override fun getNowInTheatreMovies(): Flow<List<Movie>> {
        return flow {
            emit(httpClient.getNowInTheatreMovies().items.take(5).map {
                Movie(
                    id = it.id,
                    imagePath = it.image,
                    title = it.title,
                    year = it.releaseState,
                    rating = it.imDbRating
                )
            })
        }
    }

    override fun getComingSoonMovies(): Flow<List<Movie>> {
        return flow {
            emit(httpClient.getComingSoonMovies().items.take(5).map {
                Movie(
                    id = it.id,
                    imagePath = it.image,
                    title = it.title,
                    year = it.releaseState,
                )
            })
        }
    }

    override fun getPopularMovies(): Flow<List<Movie>> {
        return flow {
            emit(httpClient.getPopularMovies().mostPopularDataDetails.take(5).map {
                Movie(
                    id = it.id,
                    imagePath = it.image,
                    title = it.title,
                    year = it.year,
                    rating = it.imDbRating
                )
            })
        }
    }

    override fun getTop250Movies(): Flow<List<Movie>> {
        return flow {
            emit(httpClient.getTopMovies().items.take(5).map {
                Movie(
                    id = it.id,
                    imagePath = it.image,
                    title = it.title,
                    rating = it.imDbRating
                )
            })
        }
    }
}