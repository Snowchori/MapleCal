package com.example.maplecal.domain

interface GrowthRepository {
    suspend fun getRequestExp(level: Int): Long

    suspend fun getExpLevel(nickname: String): Pair<String, Double>
}