package com.example.maplecal.data

import com.example.maplecal.ExpService
import com.example.maplecal.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.net.URLEncoder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpRemoteDataSource @Inject constructor(
    private val expService: ExpService
){
    suspend fun getRequestExp(level: Int): Long =
        coroutineScope {
            try {
                val exp = expService.getExp(level, level + 1, "n")
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

    suspend fun getExpLevel(nickname: String) : Pair<String, Double> = withContext(Dispatchers.IO) {
        var level = "0"
        var exp = 0.0

        val baseUrl = "https://maplestory.nexon.com"
        if (nickname != "") {
            val url = "$baseUrl/Ranking/World/Total?c=" + URLEncoder.encode(
                nickname,
                "UTF-8"
            ) + "&w=0"

            val jsoup = Jsoup.connect(url)
            val doc = jsoup.get()
            val tbody = doc.select("tbody")
            val td = tbody.select("td")
            var levelIndex = -1
            var expIndex = -1
            for (i in 0 until td.size) {
                val name = td[i].select("a")
                if (name.text() == nickname) {
                    levelIndex = i + 1
                    expIndex = i + 2
                    break
                }
            }
            if (levelIndex >= 0 && expIndex >= 0) {
                level = td[levelIndex].text().replace("Lv.", "")
                val result = getRequestExp(level.toInt())
                val expUp = td[expIndex].text().replace(",", "").toLong()
                exp = expUp * 100 / result.toDouble()
            }
        }

        Pair(level, exp)
    }
}