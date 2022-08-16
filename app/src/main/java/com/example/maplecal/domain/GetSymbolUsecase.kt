package com.example.maplecal.domain

import com.example.maplecal.data.SymbolRepository

class GetSymbolUsecase(
    private val symbolRepository: SymbolRepository
) {
    fun getArcaneGrowth(start: Int, end: Int): Int {
        var arcane = 0
        for (i in start until end) arcane += symbolRepository.getArcaneGrowth(i)

        return arcane
    }

    fun getArcaneMesoLongway(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getArcaneLongway(i)

        return meso
    }

    fun getArcaneMesoChuchu(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getArcaneChuchu(i)

        return meso
    }

    fun getArcaneMesoLehlne(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getArcaneLehlne(i)

        return meso
    }

    fun getArcaneMesoArcana(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getArcaneArcana(i)

        return meso
    }

    fun getArcaneMesoMoras(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getArcaneMoras(i)

        return meso
    }

    fun getArcaneMesoEspa(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getArcaneEspa(i)

        return meso
    }

    fun getAuthenticGrowth(start: Int, end: Int): Int {
        var arcane = 0
        for (i in start until end) arcane += symbolRepository.getAuthenticGrowth(i)

        return arcane
    }

    fun getAuthenticMesoCernium(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getAuthenticCernium(i)

        return meso
    }

    fun getAuthenticMesoArx(start: Int, end: Int): Long {
        var meso: Long = 0
        for (i in start until end) meso += symbolRepository.getAuthenticArx(i)

        return meso
    }
}