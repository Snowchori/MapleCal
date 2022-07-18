package com.example.maplecal

import retrofit2.http.GET
import retrofit2.http.Query

interface ExpService {
    @GET("/exp_api.php")
    suspend fun getExp(
        @Query("exp1") exp1: Int,
        @Query("exp2") exp2: Int,
        @Query("option") option: String
    ) : ExpResponse
}