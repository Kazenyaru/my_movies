package com.kanzen.mymovies.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.kanzen.mymovies.BuildConfig
import com.kanzen.mymovies.R
import com.kanzen.mymovies.data.model.MovieDetailModel
import com.kanzen.mymovies.data.model.MoviePagerItemModel
import kotlinx.android.synthetic.main.content_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var movieDetailViewModel: MovieDetailViewModel

    private lateinit var movieDetailModel: MovieDetailModel
    private val moviePagerItemModel: MoviePagerItemModel by lazy {
        val movieSerialized = intent.getStringExtra("MOVIE")
        Gson().fromJson(movieSerialized, MoviePagerItemModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(findViewById(R.id.toolbar))

        initComponents()
        setViewModel()
        observeViewModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun initComponents() {
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = moviePagerItemModel.title
        movie_detail_plot.text = moviePagerItemModel.overview
        movie_detail_rating.text = moviePagerItemModel.voteCount.toString()

        val url = "${BuildConfig.IMG_BASE_URL}w500${moviePagerItemModel.posterPath}"

        Glide
            .with(this)
            .load(url)
            .placeholder(R.drawable.ic_add_24)
            .error(R.drawable.ic_home_black_24dp)
            .centerCrop()
            .fitCenter()
            .into(movie_detail_poster)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun setViewModel() {
        movieDetailViewModel =
            ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
        movieDetailViewModel.fetchMovieDetail(moviePagerItemModel.id)
    }

    fun observeViewModel() {
        movieDetailViewModel.getMovieDetail().observe(this, Observer {
            if (it != null) {
                movieDetailModel = it
                movie_detail_pb.visibility = View.GONE
            }
        })
    }

}