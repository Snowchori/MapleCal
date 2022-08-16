package com.example.maplecal.data

class AuthenticLocalDataSource {

    private val authenticGrowth = listOf(0, 29, 76, 141, 224, 325, 444, 581, 736, 909, 1100)

    private val authenticCernium = listOf<Long>(
        0, 185_400_000, 273_900_000, 362_400_000, 450_900_000,
        539_400_000, 627_900_000, 716_400_000, 804_900_000, 893_400_000, 981_900_000
    )

    private val authenticArx = listOf<Long>(
        0, 203_900_000, 301_200_000, 398_500_000, 495_800_000,
        593_100_000, 690_400_000, 787_700_000, 885_000_000, 982_300_000, 1_079_600_000
    )

    fun getAuthenticGrowth(index : Int) : Int {
        return authenticGrowth[index]
    }

    fun getAuthenticCernium(index: Int) : Long {
        return authenticCernium[index]
    }

    fun getAuthenticArx(index: Int) : Long {
        return authenticArx[index]
    }
}