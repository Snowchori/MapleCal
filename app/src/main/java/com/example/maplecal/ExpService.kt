package com.example.maplecal

import com.example.maplecal.data.ExpResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ExpService {
    @GET("/exp_api.php")
    suspend fun getExp(
        @Query("exp1") exp1: Int,
        @Query("exp2") exp2: Int,
        @Query("option") option: String
    ) : ExpResponse

    companion object {
        private const val BASE_URL = "http://wachan.me"
        fun create(): ExpService {
            val gson: Gson = GsonBuilder().setLenient().create()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ExpService::class.java)
        }
    }
}