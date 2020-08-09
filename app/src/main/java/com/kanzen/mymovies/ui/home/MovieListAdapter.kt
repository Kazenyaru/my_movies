package com.kanzen.mymovies.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.kanzen.mymovies.BuildConfig
import com.kanzen.mymovies.ui.MovieDetailActivity
import com.kanzen.mymovies.R
import com.kanzen.mymovies.data.model.MoviePagerItemModel
import org.jetbrains.anko.sdk27.coroutines.onClick

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {
    var movies = listOf<MoviePagerItemModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    class ViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val movieImage: ImageView = itemView.findViewById(R.id.movie_list_poster)
        private val movieRating: TextView = itemView.findViewById(R.id.movie_list_rating)

        fun bind(moviePagerItem: MoviePagerItemModel) {
            movieRating.text = moviePagerItem.voteCount.toString()

            movieImage.onClick {
                val intent = Intent(itemView.context, MovieDetailActivity::class.java).apply {
                    putExtra("MOVIE", Gson().toJson(moviePagerItem))
                }
                itemView.context.startActivity(intent)
            }

            val url = "${BuildConfig.IMG_BASE_URL}w500${moviePagerItem.posterPath}"
            Glide
                .with(itemView)
                .load(url)
                .placeholder(R.drawable.ic_add_24)
                .error(R.drawable.ic_home_black_24dp)
                .centerCrop()
                .fitCenter()
                .into(movieImage)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.movie_list_item_component, parent, false)

                return ViewHolder(view)
            }
        }

    }
}