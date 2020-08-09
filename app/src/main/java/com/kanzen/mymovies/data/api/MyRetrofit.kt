package com.kanzen.mymovies.data.api

import com.kanzen.mymovies.BuildConfig
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object MyRetrofit {

    val api: ApiService by lazy {
        var client = OkHttpClient.Builder()
            .addInterceptor(object : Interceptor {
                @Throws(IOException::class)
                override fun intercept(chain: Interceptor.Chain): Response? {
                    var original: Request = chain.request()
                    val httpUrl: HttpUrl = original.url()
                        .newBuilder()
                        .addQueryParameter("api_key", BuildConfig.API_KEY)
                        .build()
                    original = original.newBuilder()
                        .url(httpUrl)
                        .build()
                    return chain.proceed(original)
                }
            })
            .build()

        val BASE_URL = BuildConfig.API_BASE_URL
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(ApiService::class.java)
    }
}