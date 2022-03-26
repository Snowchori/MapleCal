package com.example.maplecal

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val service: ExpService = initService()
    private const val BASE_URL = "http://wachan.me"

    private fun initService(): ExpService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExpService::class.java)
}