package com.chori.maplecal.domain

import com.chori.maplecal.domain.model.Hyper
import com.chori.maplecal.util.getHyperState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHyperUseCase @Inject constructor(
    private val hyperRepository: HyperRepository
) {
    fun getHypers(): MutableList<Hyper> {
        val hyperList = mutableListOf<Hyper>()
        for (i in 0 until hyperRepository.getHypersSize()) {
            hyperList.add(hyperRepository.getHyper(i))
        }

        return hyperList
    }

    fun getHypersSize(): Int {
        return hyperRepository.getHypersSize()
    }

    fun getHyperPoint(index: Int): Int {
        return hyperRepository.getHyperPoint(index)
    }

    fun getHyperCount(index: Int): Int {
        return hyperRepository.getHyperCount(index)
    }

    fun getHyperText(index: Int): String {
        return "${hyperRepository.getHyperName(index)} ${
            getHyperState(
                index,
                hyperRepository.getHyperCount(index)
            )
        }"
    }
}