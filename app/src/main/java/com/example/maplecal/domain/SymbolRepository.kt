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

    fun getSymbols() : Array<Symbol>

    fun getSymbolsSize() : Int

    fun getSymbol(index: Int) : Symbol

    fun getSymbolChecked(index: Int) : Boolean

    fun setSymbolLevel(index: Int, level: String)

    fun setSymbolCount(index: Int, count: String)

    fun setSymbolExtra(index: Int, mini: String)

    fun setSymbolCheked(index: Int, boolean: Boolean)
}