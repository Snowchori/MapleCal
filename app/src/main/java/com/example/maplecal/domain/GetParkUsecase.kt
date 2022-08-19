package com.example.maplecal.domain

import com.example.maplecal.domain.model.Park

class GetParkUsecase(
    private val parkRepository: ParkRepository
)  {
    fun getParks(index: Int) : Park {
        return parkRepository.getParks(index)
    }
}