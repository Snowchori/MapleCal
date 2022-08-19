package com.example.maplecal.data

import com.example.maplecal.domain.ParkRepository
import com.example.maplecal.domain.model.Park

class ParkRepositoryImpl(
    private val parkLocalDataSource: ParkLocalDataSource
) : ParkRepository {
    override fun getParks(index: Int) : Park {
        return parkLocalDataSource.getParks(index)
    }

    override fun setParksCount(index: Int, count: String) {
        parkLocalDataSource.setParksCount(index, count)
    }

    override fun setParksPoint(index: Int, point: String) {
        parkLocalDataSource.setParksPoint(index, point)
    }
}