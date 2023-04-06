package com.example.data.repository.remote

import com.example.data.model.NewsResponse
import com.example.network.Services
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NewsRepositoryImpl @Inject constructor(var newsServices: Services):NewsRepository {

    override suspend fun getNews(): Response<NewsResponse> {
        return newsServices.getBreakingNews()
    }

    override fun getBreakNews(): Flow<NewsResponse> = flow {
        while (true) {
            val latestNews = newsServices.getBreakingNewsWithFlow().body()
            latestNews?.let { emit(it) }
            delay(1000)
        }
    }
}