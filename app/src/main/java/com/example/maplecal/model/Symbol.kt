package com.example.maplecal.model

import com.example.maplecal.R
import com.example.maplecal.data.SymbolData

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

private val arcaneMoras = listOf<Long>(
    0, 14_610_000, 19_890_000, 25_170_000, 30_450_000, 35_730_000,
    41_010_000, 46_290_000, 51_570_000, 56_850_000, 62_130_000, 67_410_000, 72_690_000, 77_970_000,
    83_250_000, 88_530_000, 93_810_000, 99_090_000, 104_370_000, 109_650_000
)

private val arcaneEtc = listOf<Long>(
    0, 17_136_000, 23_076_000, 29_016_000, 34_956_000, 40_896_000,
    46_836_000, 52_776_000, 58_716_000, 64_656_000, 70_596_000, 76_536_000, 82_476_000, 88_416_000,
    94_356_000, 100_296_000, 106_236_000, 112_176_000, 118_116_000, 124_056_000
)

private val authenticGrowth = listOf(0, 29, 76, 141, 224, 325, 444, 581, 736, 909, 1100)

private val authenticCernium = listOf<Long>(
    0, 185_400_000, 273_900_000, 362_400_000, 450_900_000,
    539_400_000, 627_900_000, 716_400_000, 804_900_000, 893_400_000, 981_900_000
)

private val authenticArx = listOf<Long>(
    0, 203_900_000, 301_200_000, 398_500_000, 495_800_000,
    593_100_000, 690_400_000, 787_700_000, 885_000_000, 982_300_000, 1_079_600_000
)

fun getSymbol() = arrayOf(
    SymbolData(0, R.drawable.longways, "소멸의 여로", "미니게임\n(0 or 1)", "1", "1", "1"),
    SymbolData(1, R.drawable.chuchu, "츄츄 아일랜드", "미니게임\n(0 or 1)", "1", "1", "1"),
    SymbolData(2, R.drawable.lehlne, "레헬른", "드브 층수", "1", "1", "0"),
    SymbolData(3, R.drawable.arcana, "아르카나", "스세 점수", "1", "1", "30000"),
    SymbolData(4, R.drawable.moras, "모라스", "미니게임\n(0 or 1)", "1", "1", "1"),
    SymbolData(5, R.drawable.espa, "에스페라", "미니게임\n(0 or 1)", "1", "1", "1"),
    SymbolData(6, R.drawable.cernium, "세르니움", "세르니움(후)\n(0 or 1)", "1", "1", "1"),
    SymbolData(7, R.drawable.arx, "아크르스", "", "1", "1", "0")
)

fun getArcaneGrowth(start: Int, end: Int): Int {
    var arcane = 0
    for (i in start until end) arcane += arcaneGrowth[i]

    return arcane
}

fun getArcaneMesoLongway(start: Int, end: Int): Long {
    var meso: Long = 0
    for (i in start until end) meso += arcaneLongway[i]

    return meso
}

fun getArcaneMesoChuchu(start: Int, end: Int): Long {
    var meso: Long = 0
    for (i in start until end) meso += arcaneChuchu[i]

    return meso
}

fun getArcaneMesoMoras(start: Int, end: Int): Long {
    var meso: Long = 0
    for (i in start until end) meso += arcaneMoras[i]

    return meso
}

fun getArcaneMesoEtc(start: Int, end: Int): Long {
    var meso: Long = 0
    for (i in start until end) meso += arcaneEtc[i]

    return meso
}

fun getAuthenticGrowth(start: Int, end: Int): Int {
    var arcane = 0
    for (i in start until end) arcane += authenticGrowth[i]

    return arcane
}

fun getAuthenticMesoCernium(start: Int, end: Int): Long {
    var meso: Long = 0
    for (i in start until end) meso += authenticCernium[i]

    return meso
}

fun getAuthenticMesoArx(start: Int, end: Int): Long {
    var meso: Long = 0
    for (i in start until end) meso += authenticArx[i]

    return meso
}