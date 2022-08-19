package com.example.maplecal.domain

import com.example.maplecal.domain.model.Symbol

interface SymbolRepository {
    fun getArcaneGrowth(index:Int) : Int

    fun getArcaneLongway(index: Int) : Long

    fun getArcaneChuchu(index: Int) : Long

    fun getArcaneLehlne(index: Int) : Long

    fun getArcaneArcana(index: Int) : Long

    fun getArcaneMoras(index: Int) : Long

    fun getArcaneEspa(index: Int) : Long

    fun getAuthenticGrowth(index : Int) : Int

    fun getAuthenticCernium(index: Int) : Long

    fun getAuthenticArx(index: Int) : Long

    fun getSymbols(index: Int) : Symbol

    fun setSymbolsLevel(index: Int, level: String)

    fun setSymbolsCount(index: Int, count: String)

    fun setSymbolsExtra(index: Int, mini: String)
}