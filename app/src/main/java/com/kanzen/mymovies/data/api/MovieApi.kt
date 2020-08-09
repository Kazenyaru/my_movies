package com.kanzen.mymovies.data.api

import android.graphics.Movie
import com.google.gson.Gson
import com.kanzen.mymovies.data.model.ApiErrorModel
import com.kanzen.mymovies.data.model.MovieDetailModel
import com.kanzen.mymovies.data.model.MoviePagerModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object MovieApi {
    val api = MyRetrofit.api

    fun fetchPopularMovies(page: Int = 1, responseCallback: (MoviePagerModel?) -> Unit) {
        api.getPopularMovie(page = page)?.enqueue(object: Callback<MoviePagerModel?> {
            override fun onFailure(call: Call<MoviePagerModel?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<MoviePagerModel?>,
                response: Response<MoviePagerModel?>
            ) {
                if(response.isSuccessful) {
                    responseCallback(response.body())
                } else {
                }
            }
        })
    }

    fun fetchUpcomingMovies(page: Int = 1, responseCallback: (MoviePagerModel?) -> Unit) {
        api.getUpcomingMovie(page = page)?.enqueue(object: Callback<MoviePagerModel?> {
            override fun onFailure(call: Call<MoviePagerModel?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<MoviePagerModel?>,
                response: Response<MoviePagerModel?>
            ) {
                if(response.isSuccessful) {
                    responseCallback(response.body())
                } else {
                }
            }
        })
    }

    fun searchMovies(page: Int = 1, query: String, responseCallback: (MoviePagerModel?) -> Unit) {
        api.getSearchMovie(page = page, query = query)?.enqueue(object: Callback<MoviePagerModel?> {
            override fun onFailure(call: Call<MoviePagerModel?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<MoviePagerModel?>,
                response: Response<MoviePagerModel?>
            ) {
                if(response.isSuccessful) {
                    responseCallback(response.body())
                } else {
                }
            }
        })
    }

    fun fetchDetailMovie(id: Int, responseCallback: (MovieDetailModel?) -> Unit) {
        api.getDetailMovie(movie_id = id)?.enqueue(object: Callback<MovieDetailModel?> {
            override fun onFailure(call: Call<MovieDetailModel?>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<MovieDetailModel?>,
                response: Response<MovieDetailModel?>
            ) {
                if(response.isSuccessful) {
                    responseCallback(response.body())
                } else {
                }
            }
        })
    }

}