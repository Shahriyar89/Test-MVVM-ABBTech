package com.example.data.model

import com.google.gson.annotations.SerializedName


data class NewsResponse(
    @SerializedName("articles")
    val meqaleler: List<Article>?=null,
    @SerializedName("status")
    val status: String?=null,
    @SerializedName("totalResults")
    val totalResults: Int?=null
)