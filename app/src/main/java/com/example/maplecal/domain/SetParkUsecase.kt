package com.example.maplecal.domain

class SetParkUsecase(
    private val parkRepository: ParkRepository
) {
    fun setParksCount(index: Int, count: String) {
        parkRepository.setParksCount(index, count)
    }

    fun setParksPoint(index: Int, point: String) {
        parkRepository.setParksPoint(index, point)
    }
}