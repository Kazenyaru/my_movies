package com.kanzen.mymovies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kanzen.mymovies.data.api.MovieApi
import com.kanzen.mymovies.data.model.MovieDetailModel
import com.kanzen.mymovies.data.model.MoviePagerModel

class MovieDetailViewModel : ViewModel() {

    private val _movieDetail: MutableLiveData<MovieDetailModel> = MutableLiveData()

    fun fetchMovieDetail(id: Int) {
        MovieApi.fetchDetailMovie(id) { _movieDetail.postValue(it) }
    }

    fun getMovieDetail(): MutableLiveData<MovieDetailModel> = _movieDetail
}