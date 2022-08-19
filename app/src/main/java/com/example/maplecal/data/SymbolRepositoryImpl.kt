package com.example.maplecal.data

import com.example.maplecal.domain.SymbolRepository
import com.example.maplecal.domain.model.Symbol

class SymbolRepositoryImpl(
    private val symbolLocalDataSource: SymbolLocalDataSource
): SymbolRepository {
    override fun getArcaneGrowth(index:Int) : Int {
        return symbolLocalDataSource.getArcaneGrowth(index)
    }

    override fun getArcaneLongway(index: Int) : Long {
        return symbolLocalDataSource.getArcaneLongway(index)
    }

    override fun getArcaneChuchu(index: Int) : Long {
        return symbolLocalDataSource.getArcaneChuchu(index)
    }

    override fun getArcaneLehlne(index: Int) : Long {
        return symbolLocalDataSource.getArcaneLehlne(index)
    }

    override fun getArcaneArcana(index: Int) : Long {
        return symbolLocalDataSource.getArcaneArcana(index)
    }

    override fun getArcaneMoras(index: Int) : Long {
        return symbolLocalDataSource.getArcaneMoras(index)
    }

    override fun getArcaneEspa(index: Int) : Long {
        return symbolLocalDataSource.getArcaneEspa(index)
    }

    override fun getAuthenticGrowth(index : Int) : Int {
        return symbolLocalDataSource.getAuthenticGrowth(index)
    }

    override fun getAuthenticCernium(index: Int) : Long {
        return symbolLocalDataSource.getAuthenticCernium(index)
    }

    override fun getAuthenticArx(index: Int) : Long {
        return symbolLocalDataSource.getAuthenticArx(index)
    }

    override fun getSymbols(index: Int) : Symbol {
        return symbolLocalDataSource.getSymbols(index)
    }

    override fun setSymbolsLevel(index: Int, level: String) {
        symbolLocalDataSource.setSymbolsLevel(index, level)
    }

    override fun setSymbolsCount(index: Int, count: String) {
        symbolLocalDataSource.setSymbolsCount(index, count)
    }

    override fun setSymbolsExtra(index: Int, mini: String) {
        symbolLocalDataSource.setSymbolsExtra(index, mini)
    }
}