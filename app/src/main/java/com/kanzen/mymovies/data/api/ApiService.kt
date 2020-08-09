package com.kanzen.mymovies.data.api

import com.kanzen.mymovies.data.model.ApiErrorModel
import com.kanzen.mymovies.data.model.MovieDetailModel
import com.kanzen.mymovies.data.model.MoviePagerModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("movie/popular?")
    fun getPopularMovie(@Query("page") page: Int): Call<MoviePagerModel?>?

    @GET("search/movie")
    fun getSearchMovie(
        @Query("page") page: Int,
        @Query("query") query: String?
    ): Call<MoviePagerModel?>?

    @GET("movie/{movie_id}")
    fun getDetailMovie(@Path("movie_id") movie_id: Int?): Call<MovieDetailModel?>?

    @GET("movie/upcoming")
    fun getUpcomingMovie(
        @Query("page") page: Int
    ): Call<MoviePagerModel?>?
}