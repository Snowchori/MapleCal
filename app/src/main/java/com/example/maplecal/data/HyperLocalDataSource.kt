package com.example.maplecal.data

class HyperLocalDataSource {
    private val hyperPoint = listOf(0, 1, 3, 7, 15, 25, 40, 60, 85, 115, 150, 200, 265, 345, 440, 550)
    private val slevel = listOf(7, 11, 12, 13)
    private val elevel = listOf(15, 16)
    private val percent = listOf(4, 5, 7, 8, 9, 10, 11, 12, 15)

    fun getPoint(index: Int): Int {
        return hyperPoint[index]
    }

    fun inSlevel(index: Int) : Boolean {
        return index in slevel
    }

    fun inElevel(index: Int) : Boolean {
        return index in elevel
    }

    fun inPercent(index: Int) : Boolean {
        return index in percent
    }
}