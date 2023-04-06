package com.example.domein.usecases.news

import com.example.data.repository.remote.NewsRepository

import javax.inject.Inject

class NewsRepositoryUseCase @Inject constructor(val repository: NewsRepository) {
    fun getNews(){
        repository.getBreakNews()
    }
}
