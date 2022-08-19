package com.example.maplecal.domain

import com.example.maplecal.domain.model.Hyper

interface HyperRepository {
    fun getHyperPoint(index: Int) : Int

    fun getHypers(index: Int) : Hyper

    fun setHypersCount(index: Int, count: Int)
}