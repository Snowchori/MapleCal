package com.example.maplecal.data

class HyperRepository(
    private val hyperLocalDataSource: HyperLocalDataSource
) {
    fun getPoint(index: Int): Int {
        return hyperLocalDataSource.getPoint(index)
    }

    fun inSlevel(index: Int) : Boolean {
        return hyperLocalDataSource.inSlevel(index)
    }

    fun inElevel(index: Int) : Boolean {
        return hyperLocalDataSource.inElevel(index)
    }

    fun inPercent(index: Int) : Boolean {
        return hyperLocalDataSource.inPercent(index)
    }
}