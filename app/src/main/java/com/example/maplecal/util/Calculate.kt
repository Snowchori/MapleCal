package com.example.maplecal.util

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

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

    if (ind in listOf(7, 11, 12, 13) && level > 5) result += level - 5
    else if (ind in listOf(15, 16) && level > 10) result += (level - 10) * point

    return if (ind in listOf(4, 5, 7, 8, 9, 10, 11, 12, 15)) "$result%"
    else if (ind == 6) "$result / ${result / 10}"
    else "$result"
}

fun getPoint(cnt: Int, point: Int): String {
    val dec = DecimalFormat("#,###")
    val remain = 77 - cnt
    val q: Int = remain / (2 + point)
    val r = remain % (2 + point) - 2
    return if (r > 0) {
        dec.format(300 * (q * point + r))
    } else {
        dec.format(300 * q * point)
    }
}

@SuppressLint("SimpleDateFormat")
fun getTime(ind: Int, cnt: Int, point: Int): String {
    val remain = 77 - cnt
    val week = remain / (2 + point)

    val cal = Calendar.getInstance()
    var temp = ind + 1 - cal.get(Calendar.DAY_OF_WEEK)
    if (temp < 0) temp += 7
    cal.time = Date()

    val df: DateFormat = SimpleDateFormat("yyyy-MM-dd")

    cal.add(Calendar.DATE, temp + week * 7)

    return df.format(cal.time)
}