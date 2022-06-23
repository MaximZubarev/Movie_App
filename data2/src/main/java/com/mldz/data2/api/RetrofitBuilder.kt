package com.mldz.data2.api

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor;
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    private const val BASE_URL = "https://imdb-api.com/ru/API/"

    private fun getRetrofit(): Retrofit {
        val okHttp = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(OkHttpProfilerInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
    }

    val apiService: ApiServiceImdb = getRetrofit().create(ApiServiceImdb::class.java)
}