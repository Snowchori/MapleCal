package com.example.maplecal.domain

import com.example.maplecal.domain.model.Hyper
import com.example.maplecal.util.getHyperState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHyperUsecase @Inject constructor(
    private val hyperRepository: HyperRepository
) {
    fun getHypers() : MutableList<Hyper> {
        val hyperList = mutableListOf<Hyper>()
        for (i in 0 until hyperRepository.getHypersSize()) {
            hyperList.add(hyperRepository.getHyper(i))
        }

        return hyperList
    }

    fun getHypersSize() : Int {
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