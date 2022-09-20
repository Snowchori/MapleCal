package com.example.maplecal.data

import com.example.maplecal.data.local.ParkLocalDataSource
import com.example.maplecal.domain.ParkRepository
import com.example.maplecal.domain.model.Park
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParkRepositoryImpl @Inject constructor(
    private val parkLocalDataSource: ParkLocalDataSource
) : ParkRepository {
    override fun getParks(): Array<Park> {
        return parkLocalDataSource.getParks()
    }

    override fun getParksSize(): Int {
        return parkLocalDataSource.getParksSize()
    }

    override fun getPark(index: Int): Park {
        return parkLocalDataSource.getPark(index)
    }

    override fun getParkChecked(index: Int): Boolean {
        return parkLocalDataSource.getParkChecked(index)
    }

    override fun setParkCount(index: Int, count: String) {
        parkLocalDataSource.setParkCount(index, count)
    }

    override fun setParkPoint(index: Int, point: String) {
        parkLocalDataSource.setParkPoint(index, point)
    }

    override fun setParkChecked(index: Int, boolean: Boolean) {
        parkLocalDataSource.setParkChecked(index, boolean)
    }
}