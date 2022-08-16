package com.example.maplecal.data

class SymbolRepository(
    private val arcaneLocalDataSource: ArcaneLocalDataSource,
    private val authenticLocalDataSource: AuthenticLocalDataSource
) {
    fun getArcaneGrowth(index:Int) : Int {
        return arcaneLocalDataSource.getArcaneGrowth(index)
    }

    fun getArcaneLongway(index: Int) : Long {
        return arcaneLocalDataSource.getArcaneLongway(index)
    }

    fun getArcaneChuchu(index: Int) : Long {
        return arcaneLocalDataSource.getArcaneChuchu(index)
    }

    fun getArcaneLehlne(index: Int) : Long {
        return arcaneLocalDataSource.getArcaneLehlne(index)
    }

    fun getArcaneArcana(index: Int) : Long {
        return arcaneLocalDataSource.getArcaneArcana(index)
    }

    fun getArcaneMoras(index: Int) : Long {
        return arcaneLocalDataSource.getArcaneMoras(index)
    }

    fun getArcaneEspa(index: Int) : Long {
        return arcaneLocalDataSource.getArcaneEspa(index)
    }

    fun getAuthenticGrowth(index : Int) : Int {
        return authenticLocalDataSource.getAuthenticGrowth(index)
    }

    fun getAuthenticCernium(index: Int) : Long {
        return authenticLocalDataSource.getAuthenticCernium(index)
    }

    fun getAuthenticArx(index: Int) : Long {
        return authenticLocalDataSource.getAuthenticArx(index)
    }
}