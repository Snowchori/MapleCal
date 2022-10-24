package com.chori.maplecal.data

import com.chori.maplecal.data.local.HyperLocalDataSource
import com.chori.maplecal.domain.HyperRepository
import com.chori.maplecal.domain.model.Hyper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HyperRepositoryImpl @Inject constructor(
    private val hyperLocalDataSource: HyperLocalDataSource
) : HyperRepository {
    override fun getHypers(): Array<Hyper> {
        return hyperLocalDataSource.getHypers()
    }

    override fun getHypersSize(): Int {
        return hyperLocalDataSource.getHypersSize()
    }

    override fun getHyper(index: Int): Hyper {
        return hyperLocalDataSource.getHyper(index)
    }

    override fun getHyperPoint(index: Int): Int {
        return hyperLocalDataSource.getHyperPoint(index)
    }

    override fun getHyperCount(index: Int): Int {
        return hyperLocalDataSource.getHyperCount(index)
    }

    override fun getHyperName(index: Int): String {
        return hyperLocalDataSource.getHyperName(index)
    }

    override fun setHypersCount(index: Int, count: String) {
        hyperLocalDataSource.setHypersCount(index, count)
    }

    override fun setInit() {
        hyperLocalDataSource.setInit()
    }
}