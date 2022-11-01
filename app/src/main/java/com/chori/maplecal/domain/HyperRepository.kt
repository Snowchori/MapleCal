package com.chori.maplecal.domain

import com.chori.maplecal.domain.model.Hyper

interface HyperRepository {
    fun getHypers(): Array<Hyper>

    fun getHypersSize(): Int

    fun getHyper(index: Int): Hyper

    fun getHyperPoint(index: Int): Int

    fun getHyperCount(index: Int): Int

    fun getHyperName(index: Int): String

    fun setHypersCount(index: Int, count: String)

    fun setInit()
}