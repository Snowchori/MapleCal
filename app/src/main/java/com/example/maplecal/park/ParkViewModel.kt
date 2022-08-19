package com.example.maplecal.park

import com.example.maplecal.domain.model.Park
import com.example.maplecal.data.ParkRepositoryImpl
import com.example.maplecal.domain.GetParkUsecase
import com.example.maplecal.domain.SetParkUsecase

class ParkViewModel(
    private val getParkUsecase: GetParkUsecase,
    private val setParkUsecase: SetParkUsecase
){
}