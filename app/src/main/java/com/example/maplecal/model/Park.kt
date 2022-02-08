package com.example.maplecal.model

import com.example.maplecal.R
import com.example.maplecal.data.ParkData

fun getPark() = arrayOf(
    ParkData(0, R.drawable.sunday, "일요일 훈장", "0", "0"),
    ParkData(1, R.drawable.monday, "월요일 훈장", "0", "0"),
    ParkData(2, R.drawable.tuesday, "화요일 훈장", "0", "0"),
    ParkData(3, R.drawable.wednesday, "수요일 훈장", "0", "0"),
    ParkData(4, R.drawable.thursday, "목요일 훈장", "0", "0"),
    ParkData(5, R.drawable.friday, "금요일 훈장", "0", "0"),
    ParkData(6, R.drawable.saturday, "토요일 훈장", "0", "0")
)