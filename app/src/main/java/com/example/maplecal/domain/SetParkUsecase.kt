package com.example.maplecal.domain

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetParkUsecase @Inject constructor(
    private val parkRepository: ParkRepository
) {
    fun setParkCount(index: Int, count: String) {
        parkRepository.setParkCount(index, count)
    }

    fun setParkPoint(index: Int, point: String) {
        parkRepository.setParkPoint(index, point)
    }

    fun setParkChecked(index:Int, boolean: Boolean) {
        parkRepository.setParkChecked(index, boolean)
    }
}