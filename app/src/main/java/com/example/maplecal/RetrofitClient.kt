package com.example.maplecal

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val service: ExpService = initService()
    private const val BASE_URL = "http://wachan.me"

    private fun initService(): ExpService {
        val gson: Gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ExpService::class.java)
    }
}