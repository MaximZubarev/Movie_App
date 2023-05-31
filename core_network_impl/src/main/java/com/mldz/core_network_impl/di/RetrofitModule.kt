package com.mldz.core_network_impl.di

import com.mldz.core_network_impl.BuildConfig
import com.mldz.core_network_impl.retrofit.MovieApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.internal.platform.android.AndroidLogHandler.setLevel
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BACKEND_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiKeyInterceptor(): Interceptor {
        return Interceptor {
            val originalRequest = it.request()
            val newHttpUrl = originalRequest.url.newBuilder()
                .addPathSegment(BuildConfig.SECRET_KEY)
                .build()
            val newRequest = originalRequest.newBuilder()
                .url(newHttpUrl)
                .build()
            it.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                if (BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            }
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        apiKeyInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.connectTimeout(40, TimeUnit.SECONDS)
        client.readTimeout(40, TimeUnit.SECONDS)
        client.addInterceptor(apiKeyInterceptor)
        client.addInterceptor(httpLoggingInterceptor)
        return client.build()
    }
}