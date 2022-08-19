package com.example.maplecal.hyper

import com.example.maplecal.domain.GetHyperUsecase
import com.example.maplecal.domain.SetHyperUsecase
import com.example.maplecal.util.getGainPoint

class HyperViewModel(
    private val getHyperUsecase: GetHyperUsecase,
    private val setHyperUsecase: SetHyperUsecase
) {
    fun getRemainPoint(level: Int): String {
        return if (level < 140) "0"
        else {
            var usePoint = 0
            for (i in 0 until adapter.datalist.size) usePoint += hyperPoint[adapter.datalist[i].hyperCount]

            (getGainPoint(level) - usePoint).toString()
        }
    }
}