package com.example.maplecal.domain

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetGrowthUseCase @Inject constructor(
    private val growthRepository: GrowthRepository
) {
    suspend fun getExpResult(level: Int, percent: Double, data: MutableList<Int>): String {
        var lev = level
        var requestExp = growthRepository.getRequestExp(lev)
        var exp = (requestExp * percent / 100).toLong()
        for (i in 0 until 6) {
            for (j in 0 until data[i]) {
                val getExp = if (lev >= 200 + 10 * i) growthRepository.getRequestExp(199 + 10 * i)
                else growthRepository.getRequestExp(lev)
                exp += getExp
                if (requestExp <= exp) {
                    lev += 1
                    exp -= requestExp
                    requestExp = growthRepository.getRequestExp(lev)
                }
            }
        }
        val expPercent: Double = exp * 100 / requestExp.toDouble()
        return "$lev 레벨 " + String.format("%.3f", expPercent) + "%"
    }

    suspend fun getExpLevel(nickname: String): Pair<String, Double> {
        return growthRepository.getExpLevel(nickname)
    }
}