package com.example.maplecal.data

import com.example.maplecal.domain.model.Park

class ParkLocalDataSource {
    private val parks = arrayOf(
        Park(0, "일요일 훈장", "0", "0"),
        Park(1, "월요일 훈장", "0", "0"),
        Park(2, "화요일 훈장", "0", "0"),
        Park(3, "수요일 훈장", "0", "0"),
        Park(4, "목요일 훈장", "0", "0"),
        Park(5, "금요일 훈장", "0", "0"),
        Park(6, "토요일 훈장", "0", "0")
    )

    fun getParks(index: Int) : Park {
        return parks[index]
    }

    fun setParksCount(index: Int, count: String) {
        parks[index].parkCount = count
    }

    fun setParksPoint(index: Int, point: String) {
        parks[index].parkPoint = point
    }
}