package com.example.maplecal.model

import com.example.maplecal.ExpService
import com.example.maplecal.RetrofitClient
import kotlinx.coroutines.*

suspend fun getExpResult(level: Int, percent: Double, data: MutableList<Int>): String {
    var lev = level
    var requestExp = getRequestExp(lev)
    var exp = (requestExp * percent / 100).toLong()
    for (i in 0 until 6) {
        for (j in 0 until data[i]) {
            val getExp = if (lev >= 200 + 10 * i) getRequestExp(199 + 10 * i)
            else getRequestExp(lev)
            exp += getExp
            if (requestExp <= exp) {
                lev += 1
                exp -= requestExp
                requestExp = getRequestExp(lev)
            }
        }
    }
    val expPercent: Double = exp * 100 / requestExp.toDouble()
    return "$lev 레벨 " + String.format("%.3f", expPercent) + "%"
}

suspend fun getRequestExp(level: Int): Long =
    coroutineScope {
        try {
            val exp = RetrofitClient.service.getExp(level, level + 1, "n")
            when (exp.error) {
                "false" -> {
                    return@coroutineScope exp.result.toLong()
                }
                else -> return@coroutineScope 1
            }
        } catch (e: Exception) {
            return@coroutineScope 2
        }
    }