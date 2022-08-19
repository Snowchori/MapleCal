package com.example.maplecal.domain

class SetSymbolUsecase(
    private val symbolRepository: SymbolRepository
) {
    fun setSymbolsLevel(index: Int, level: String) {
        symbolRepository.setSymbolsLevel(index, level)
    }

    fun setSymbolsCount(index: Int, count: String) {
        symbolRepository.setSymbolsCount(index, count)
    }

    fun setSymbolsExtra(index: Int, mini: String) {
        symbolRepository.setSymbolsExtra(index, mini)
    }
}