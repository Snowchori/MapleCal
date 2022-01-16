package com.example.maplecal.model

import com.example.maplecal.R
import com.example.maplecal.SymbolData

fun getSymbol() = arrayOf(
    SymbolData(0, R.drawable.longways, "소멸의 여로", "미니게임\n(0 or 1)","1" ,"1", "1"),
    SymbolData(1, R.drawable.chuchu, "츄츄 아일랜드", "미니게임\n(0 or 1)", "1", "1", "1"),
    SymbolData(2, R.drawable.lehlne, "레헬른", "드브 층수", "1", "1", "0"),
    SymbolData(3, R.drawable.arcana, "아르카나", "스세 점수", "1", "1", "30000"),
    SymbolData(4, R.drawable.moras, "모라스", "미니게임\n(0 or 1)","1" , "1", "1"),
    SymbolData(5, R.drawable.espa, "에스페라", "미니게임\n(0 or 1)", "1", "1", "1"),
    SymbolData(6, R.drawable.cernium, "세르니움", "세르니움(후)\n(0 or 1)", "1", "1", "1"),
    SymbolData(7, R.drawable.arx, "아크르스", "", "1", "1", "0")
)

fun getArcaneGrowth(start : Int, end : Int) : Int = (end*(end + 1)*(2*end + 1) - start*(start + 1)*(2*start + 1))/6 + 11*(end-start)

fun getArcaneMesoLittle(start: Long, end: Long) : Long = 7130000*(end*(end + 1) - start*(start + 1))/2 + 2370000*(end - start) - 9500000

fun getArcaneMesoMuch(start : Long, end : Long) : Long = 6600000*(end*(end + 1) - start*(start + 1))/2 + 12440000*(end - start)

fun getAuthenticGrowth(start: Int, end: Int) : Int = 9*(end*(end + 1)*(2*end + 1) - start*(start + 1)*(2*start + 1))/6 +
        20*(end*(end + 1) - start*(start + 1))/2

fun getAuthenticMesoCernium(start: Long, end: Long) : Long = 88500000*(end*(end + 1) - start*(start + 1))/2 + 96900000*(end - start)

fun getAuthenticMesoArx(start: Long, end: Long) : Long = 97300000*(end*(end + 1) - start*(start + 1))/2 + 106600000*(end - start)