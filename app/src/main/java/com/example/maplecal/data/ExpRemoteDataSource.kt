package com.example.maplecal.data

import com.example.maplecal.RetrofitClient
import kotlinx.coroutines.coroutineScope

class ExpRemoteDataSource {
    suspend fun getRequestExp(level: Int): Long =
        coroutineScope {
            try {
                val exp = RetrofitClient.service.getExp(level, level + 1, "n")
                when (exp.error) {
                    "false" -> {
                        return@coroutineScope exp.result.toLong()
                    }
                    else -> return@coroutineScope 0
                }
            } catch (e: Exception) {
                return@coroutineScope -1
            }
        }
}