package com.example.maplecal.domain

import com.example.maplecal.domain.model.Park
import com.example.maplecal.domain.model.Symbol
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetParkUsecase @Inject constructor(
    private val parkRepository: ParkRepository
)  {
    fun getParks() :  MutableList<Park> {
        val parkList = mutableListOf<Park>()
        for (i in 0 until parkRepository.getParksSize()) {
            if (parkRepository.getParkChecked(i)) {
                parkList.add(parkRepository.getPark(i))
            }
        }

        return parkList
    }
}