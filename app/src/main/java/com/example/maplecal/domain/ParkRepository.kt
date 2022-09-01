package com.example.maplecal.domain

import com.example.maplecal.domain.model.Park

interface ParkRepository {
    fun getParks() : Array<Park>

    fun getParksSize() : Int

    fun getPark(index: Int) : Park

    fun getParkChecked(index: Int): Boolean

    fun setParkCount(index: Int, count: String)

    fun setParkPoint(index: Int, point: String)

    fun setParkChecked(index:Int, boolean: Boolean)
}