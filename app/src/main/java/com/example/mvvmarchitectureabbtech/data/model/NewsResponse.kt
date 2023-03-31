package com.example.mvvmarchitectureabbtech.data.model

import com.google.gson.annotations.SerializedName


data class NewsResponse(
    @SerializedName("articles")
    val meqaleler: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)