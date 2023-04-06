package com.example.data.repository.remote

import com.example.data.model.NewsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(): Response<NewsResponse>
    fun getBreakNews(): Flow<NewsResponse>
}