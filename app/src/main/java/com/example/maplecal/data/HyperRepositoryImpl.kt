package com.example.maplecal.data

import com.example.maplecal.domain.HyperRepository
import com.example.maplecal.domain.model.Hyper

class HyperRepositoryImpl(
    private val hyperLocalDataSource: HyperLocalDataSource
) : HyperRepository{
    override fun getHyperPoint(index: Int): Int {
        return hyperLocalDataSource.getHyperPoint(index)
    }

    override fun getHypers(index: Int) : Hyper {
        return hyperLocalDataSource.getHypers(index)
    }

    override fun setHypersCount(index: Int, count: Int) {
        hyperLocalDataSource.setHypersCount(index, count)
    }
}