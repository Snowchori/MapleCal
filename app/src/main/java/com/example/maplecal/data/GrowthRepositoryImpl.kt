package com.example.maplecal.data

import com.example.maplecal.domain.GrowthRepository

class GrowthRepositoryImpl(
    private val expRemoteDataSource: ExpRemoteDataSource
) : GrowthRepository {
    override suspend fun getRequestExp(level: Int): Long =
        expRemoteDataSource.getRequestExp(level)
}