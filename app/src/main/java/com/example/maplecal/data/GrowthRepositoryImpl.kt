package com.example.maplecal.data

import com.example.maplecal.domain.GrowthRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.exp

@Singleton
class GrowthRepositoryImpl @Inject constructor(
    private val expRemoteDataSource: ExpRemoteDataSource
) : GrowthRepository {
    override suspend fun getRequestExp(level: Int): Long =
        expRemoteDataSource.getRequestExp(level)

    override suspend fun getExpLevel(nickname: String) : Pair<String, Double> =
        expRemoteDataSource.getExpLevel(nickname)
}