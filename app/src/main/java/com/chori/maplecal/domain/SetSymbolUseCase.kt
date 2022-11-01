package com.chori.maplecal.domain

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetSymbolUseCase @Inject constructor(
    private val symbolRepository: SymbolRepository
) {
    fun setSymbolLevel(index: Int, level: String) {
        symbolRepository.setSymbolLevel(index, level)
    }

    fun setSymbolCount(index: Int, count: String) {
        symbolRepository.setSymbolCount(index, count)
    }

    fun setSymbolExtra(index: Int, mini: String) {
        symbolRepository.setSymbolExtra(index, mini)
    }

    fun setSymbolCheked(index: Int, boolean: Boolean) {
        symbolRepository.setSymbolCheked(index, boolean)
    }
}