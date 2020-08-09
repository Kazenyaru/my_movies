package com.kanzen.mymovies.data.model

import com.google.gson.annotations.SerializedName

data class MoviePagerModel (
    val page: Int,
    val results: List<MoviePagerItemModel>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int
) : ApiResponseModel

data class MoviePagerItemModel (
    @SerializedName("poster_path")
    val posterPath: String,

    val adult: Boolean,
    val overview: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("genre_ids")
    val genreIDS: List<Int>,

    val id: Int,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("original_language")
    val originalLanguage: String,

    val title: String,

    @SerializedName("backdrop_path")
    val backdropPath: String,

    val popularity: Double,

    @SerializedName("vote_count")
    val voteCount: Int,

    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Double
)