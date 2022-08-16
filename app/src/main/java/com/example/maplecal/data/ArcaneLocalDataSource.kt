package com.example.maplecal.data

class ArcaneLocalDataSource {
    private val arcaneGrowth = listOf(
        0, 12, 15, 20, 27, 36, 47, 60, 75, 92, 111, 132, 155, 180,
        207, 236, 267, 300, 335, 372
    )

    private val arcaneLongway = listOf<Long>(
        0, 7_070_000, 11_030_000, 14_990_000, 18_950_000, 22_910_000,
        26_870_000, 30_830_000, 34_790_000, 38_750_000, 42_710_000, 46_670_000, 50_630_000, 54_590_000,
        58_550_000, 62_510_000, 66_470_000, 70_430_000, 74_390_000, 78_350_000
    )

    private val arcaneChuchu = listOf<Long>(
        0, 10_840_000, 15_460_000, 20_080_000, 24_700_000, 29_320_000,
        33_940_000, 38_560_000, 43_180_000, 47_800_000, 52_420_000, 57_040_000, 61_660_000, 66_280_000,
        70_900_000, 75_520_000, 80_140_000, 84_760_000, 89_380_000, 94_000_000
    )

    private val arcaneLehlne = listOf<Long>(
        0, 14_610_000, 19_890_000, 25_170_000, 30_450_000, 35_730_000,
        41_010_000, 46_290_000, 51_570_000, 56_850_000, 62_130_000, 67_410_000, 72_690_000, 77_970_000,
        83_250_000, 88_530_000, 93_810_000, 99_090_000, 104_370_000, 109_650_000
    )

    private val arcaneArcana = listOf<Long>(
        0, 17_136_000, 23_076_000, 29_016_000, 34_956_000, 40_896_000,
        46_836_000, 52_776_000, 58_716_000, 64_656_000, 70_596_000, 76_536_000, 82_476_000, 88_416_000,
        94_356_000, 100_296_000, 106_236_000, 112_176_000, 118_116_000, 124_056_000
    )

    private val arcaneMoras = listOf<Long>(
        0, 17_136_000, 23_076_000, 29_016_000, 34_956_000, 40_896_000,
        46_836_000, 52_776_000, 58_716_000, 64_656_000, 70_596_000, 76_536_000, 82_476_000, 88_416_000,
        94_356_000, 100_296_000, 106_236_000, 112_176_000, 118_116_000, 124_056_000
    )

    private val arcaneEspa = listOf<Long>(
        0, 17_136_000, 23_076_000, 29_016_000, 34_956_000, 40_896_000,
        46_836_000, 52_776_000, 58_716_000, 64_656_000, 70_596_000, 76_536_000, 82_476_000, 88_416_000,
        94_356_000, 100_296_000, 106_236_000, 112_176_000, 118_116_000, 124_056_000
    )

    fun getArcaneGrowth(index:Int) : Int {
        return arcaneGrowth[index]
    }

    fun getArcaneLongway(index: Int) : Long {
        return arcaneLongway[index]
    }

    fun getArcaneChuchu(index: Int) : Long {
        return arcaneChuchu[index]
    }

    fun getArcaneLehlne(index: Int) : Long {
        return arcaneLehlne[index]
    }

    fun getArcaneArcana(index: Int) : Long {
        return arcaneArcana[index]
    }

    fun getArcaneMoras(index: Int) : Long {
        return arcaneMoras[index]
    }

    fun getArcaneEspa(index: Int) : Long {
        return arcaneEspa[index]
    }
}