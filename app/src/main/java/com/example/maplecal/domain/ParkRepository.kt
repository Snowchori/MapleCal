package com.example.maplecal.domain

import com.example.maplecal.domain.model.Park

interface ParkRepository {
    fun getParks(index: Int) : Park

    fun setParksCount(index: Int, count: String)

    fun setParksPoint(index: Int, point: String)
}