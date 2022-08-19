package com.example.maplecal.data

import com.example.maplecal.domain.model.Hyper

class HyperLocalDataSource {

    private val hyperPoint = listOf(0, 1, 3, 7, 15, 25, 40, 60, 85, 115, 150, 200, 265, 345, 440, 550)

    private val hypers = arrayOf(
        Hyper(0, "STR", 0),
        Hyper(1, "DEX", 0),
        Hyper(2, "INT", 0),
        Hyper(3, "LUK", 0),
        Hyper(4, "HP", 0),
        Hyper(5, "MP", 0),
        Hyper(6, "DF/TF/PP", 0),
        Hyper(7, "크확", 0),
        Hyper(8, "크뎀", 0),
        Hyper(9, "방무", 0),
        Hyper(10, "데미지", 0),
        Hyper(11, "보공", 0),
        Hyper(12, "일몹뎀", 0),
        Hyper(13, "내성", 0),
        Hyper(14, "공/마", 0),
        Hyper(15, "경험치", 0),
        Hyper(16, "포스", 0)
    )

    fun getHyperPoint(index: Int) : Int {
        return hyperPoint[index]
    }

    fun getHypers(index: Int) : Hyper {
        return hypers[index]
    }

    fun setHypersCount(index: Int, count: Int) {
        hypers[index].hyperCount = count
    }
}