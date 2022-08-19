package com.example.maplecal.domain

interface GrowthRepository {
    suspend fun getRequestExp(level: Int): Long
}