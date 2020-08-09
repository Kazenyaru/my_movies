package com.kanzen.mymovies.ui.home

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kanzen.mymovies.R
import com.kanzen.mymovies.data.model.MoviePagerModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var movieListAdapter: MovieListAdapter

    private lateinit var moviePagerModel: MoviePagerModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initComponents()
        setViewModel()
        observeViewModel()
    }

    fun initComponents() {
        movieListAdapter = MovieListAdapter()
        movie_list_rc.adapter = movieListAdapter
    }

    fun setViewModel() {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.fetchMoviesPager()
    }

    fun observeViewModel() {
        homeViewModel.getMoviesPager().observe(this, Observer {
            if (it != null) {
                moviePagerModel = it
                movieListAdapter.movies = it.results
                movie_list_pb.visibility = View.GONE
            }
        })
    }
}