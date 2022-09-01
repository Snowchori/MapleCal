package com.example.maplecal.data

import com.example.maplecal.domain.model.Park
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParkLocalDataSource @Inject constructor(){
    private val parks = arrayOf(
        Park(0, "일요일 훈장", "0", "0", false),
        Park(1, "월요일 훈장", "0", "0", false),
        Park(2, "화요일 훈장", "0", "0", false),
        Park(3, "수요일 훈장", "0", "0", false),
        Park(4, "목요일 훈장", "0", "0", false),
        Park(5, "금요일 훈장", "0", "0", false),
        Park(6, "토요일 훈장", "0", "0", false)
    )

    fun getParks() : Array<Park> {
        return parks
    }

    fun getParksSize() : Int {
        return parks.size
    }

    fun getPark(index: Int) : Park {
        return parks[index]
    }

    fun getParkChecked(index: Int): Boolean {
        return parks[index].parkCheked
    }

    fun setParkCount(index: Int, count: String) {
        parks[index].parkCount = count
    }

    fun setParkPoint(index: Int, point: String) {
        parks[index].parkPoint = point
    }

    fun setParkChecked(index:Int, boolean: Boolean) {
        parks[index].parkCheked = boolean
    }
}