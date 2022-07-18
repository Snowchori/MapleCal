package com.example.maplecal.model

import com.example.maplecal.HyperData

val hyperPoint = listOf(0, 1, 3, 7, 15, 25, 40, 60, 85, 115, 150, 200, 265, 345, 440, 550)

fun getGainPoint(level: Int): Int {
    val one = level % 10
    return when (level) {
        in 140..149 -> 3 + 3 * one
        in 150..159 -> 34 + 4 * one
        in 160..169 -> 75 + 5 * one
        in 170..179 -> 126 + 6 * one
        in 180..189 -> 187 + 7 * one
        in 190..199 -> 258 + 8 * one
        in 200..209 -> 339 + 9 * one
        in 210..219 -> 430 + 10 * one
        in 220..229 -> 531 + 11 * one
        in 230..239 -> 642 + 12 * one
        in 240..249 -> 763 + 13 * one
        in 250..259 -> 894 + 14 * one
        in 260..269 -> 1035 + 15 * one
        in 270..279 -> 1186 + 16 * one
        in 280..289 -> 1347 + 17 * one
        in 290..300 -> 1518 + 18 * one
        else -> 0
    }
}

fun getHyperState(ind: Int, level: Int): String {
    val slevel = listOf(7, 11, 12, 13)
    val elevel = listOf(15, 16)
    val percent = listOf(4, 5, 7, 8, 9, 10, 11, 12, 15)

    val point = when (ind) {
        in 0..3 -> 30.0
        4, 5 -> 2.0
        6 -> 10.0
        7, 8, 13 -> 1.0
        9, 10, 11, 12, 14 -> 3.0
        15 -> 0.5
        16 -> 5.0
        else -> 0.0
    }

    var result = point * level

    if (ind in slevel && level > 5) result += level - 5
    else if (ind in elevel && level > 10) result += (level - 10) * point

    return if (ind in percent) "$result%"
    else if (ind == 6) "$result / ${result / 10}"
    else "$result"
}

fun getHyper() = arrayOf(
    HyperData(0, "STR", 0),
    HyperData(1, "DEX", 0),
    HyperData(2, "INT", 0),
    HyperData(3, "LUK", 0),
    HyperData(4, "HP", 0),
    HyperData(5, "MP", 0),
    HyperData(6, "DF/TF/PP", 0),
    HyperData(7, "크확", 0),
    HyperData(8, "크뎀", 0),
    HyperData(9, "방무", 0),
    HyperData(10, "데미지", 0),
    HyperData(11, "보공", 0),
    HyperData(12, "일몹뎀", 0),
    HyperData(13, "내성", 0),
    HyperData(14, "공/마", 0),
    HyperData(15, "경험치", 0),
    HyperData(16, "포스", 0)
)