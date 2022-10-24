package com.chori.maplecal.data

import com.chori.maplecal.data.local.SymbolLocalDataSource
import com.chori.maplecal.domain.SymbolRepository
import com.chori.maplecal.domain.model.Symbol
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SymbolRepositoryImpl @Inject constructor(
    private val symbolLocalDataSource: SymbolLocalDataSource
) : SymbolRepository {
    override fun getArcaneGrowth(index: Int): Int {
        return symbolLocalDataSource.getArcaneGrowth(index)
    }

    override fun getArcaneLongway(index: Int): Long {
        return symbolLocalDataSource.getArcaneLongway(index)
    }

    override fun getArcaneChuchu(index: Int): Long {
        return symbolLocalDataSource.getArcaneChuchu(index)
    }

    override fun getArcaneLehlne(index: Int): Long {
        return symbolLocalDataSource.getArcaneLehlne(index)
    }

    override fun getArcaneArcana(index: Int): Long {
        return symbolLocalDataSource.getArcaneArcana(index)
    }

    override fun getArcaneMoras(index: Int): Long {
        return symbolLocalDataSource.getArcaneMoras(index)
    }

    override fun getArcaneEspa(index: Int): Long {
        return symbolLocalDataSource.getArcaneEspa(index)
    }

    override fun getAuthenticGrowth(index: Int): Int {
        return symbolLocalDataSource.getAuthenticGrowth(index)
    }

    override fun getAuthenticCernium(index: Int): Long {
        return symbolLocalDataSource.getAuthenticCernium(index)
    }

    override fun getAuthenticArx(index: Int): Long {
        return symbolLocalDataSource.getAuthenticArx(index)
    }

    override fun getSymbols(): Array<Symbol> {
        return symbolLocalDataSource.getSymbols()
    }

    override fun getSymbolsSize(): Int {
        return symbolLocalDataSource.getSymbolsSize()
    }

    override fun getSymbol(index: Int): Symbol {
        return symbolLocalDataSource.getSymbol(index)
    }

    override fun getSymbolChecked(index: Int): Boolean {
        return symbolLocalDataSource.getSymbolChecked(index)
    }

    override fun setSymbolLevel(index: Int, level: String) {
        symbolLocalDataSource.setSymbolLevel(index, level)
    }

    override fun setSymbolCount(index: Int, count: String) {
        symbolLocalDataSource.setSymbolCount(index, count)
    }

    override fun setSymbolExtra(index: Int, mini: String) {
        symbolLocalDataSource.setSymbolExtra(index, mini)
    }

    override fun setSymbolCheked(index: Int, boolean: Boolean) {
        symbolLocalDataSource.setSymbolCheked(index, boolean)
    }
}