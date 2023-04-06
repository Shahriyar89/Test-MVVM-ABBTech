package com.example.network

import com.example.data.model.NewsResponse
import com.example.mvvmarchitectureabbtech.network.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY,
    ): Response<NewsResponse>

    @GET("v2/top-headlines/e")
    suspend fun getBreakingNewsWithFlow(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY,
    ): Response<NewsResponse>
}