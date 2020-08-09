package com.kanzen.mymovies.data.model

import com.google.gson.annotations.SerializedName

data class ApiErrorModel (
    val page: Int,
    val results: List<MoviePagerItemModel>,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int
) : ApiResponseModel