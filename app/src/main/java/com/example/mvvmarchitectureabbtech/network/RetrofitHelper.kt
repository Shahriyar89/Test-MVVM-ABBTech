package com.example.mvvmarchitectureabbtech.network

import com.example.mvvmarchitectureabbtech.network.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofitInstance(): Services =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Services::class.java)

}