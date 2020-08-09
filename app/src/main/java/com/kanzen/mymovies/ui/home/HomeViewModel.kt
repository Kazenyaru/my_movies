package com.kanzen.mymovies.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kanzen.mymovies.data.api.MovieApi
import com.kanzen.mymovies.data.model.MoviePagerModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    private val _moviesPager: MutableLiveData<MoviePagerModel> = MutableLiveData()

    fun fetchMoviesPager() {
        MovieApi.fetchPopularMovies { _moviesPager.postValue(it) }
    }

    fun getMoviesPager(): MutableLiveData<MoviePagerModel> = _moviesPager

    val text: LiveData<String> = _text
}