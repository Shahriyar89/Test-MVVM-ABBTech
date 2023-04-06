package com.example.mvvmarchitectureabbtech.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("appid", "hello")
            .addHeader("deviceplatform", "android")
            .removeHeader("User-Agent")
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0"
            )
            .build()
        return chain.proceed(request)
    }
}