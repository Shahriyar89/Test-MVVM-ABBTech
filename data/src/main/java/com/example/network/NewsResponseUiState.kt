package com.example.mvvmarchitectureabbtech.network

import com.example.data.model.NewsResponse


sealed class NewsResponseUiState{
    data class Success(val data : NewsResponse?=null) :NewsResponseUiState()
    data class Error (val error :Throwable) :NewsResponseUiState()
    data class Loading ( val loading:String):NewsResponseUiState()
}
