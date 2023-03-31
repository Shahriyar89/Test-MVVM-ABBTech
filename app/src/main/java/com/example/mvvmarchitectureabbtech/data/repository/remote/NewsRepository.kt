package com.example.mvvmarchitectureabbtech.data.repository.remote

import com.example.mvvmarchitectureabbtech.data.model.Article
import com.example.mvvmarchitectureabbtech.data.model.NewsResponse
import com.example.mvvmarchitectureabbtech.network.RetrofitHelper.getRetrofitInstance
import retrofit2.Response

class NewsRepository {
    private val newsServices = getRetrofitInstance()

    suspend fun getNews(): Response<NewsResponse> {
        return newsServices.getBreakingNews()
    }
}