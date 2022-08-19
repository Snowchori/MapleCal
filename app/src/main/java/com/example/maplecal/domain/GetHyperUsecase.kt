package com.example.maplecal.domain

import com.example.maplecal.domain.model.Hyper

class GetHyperUsecase(
    private val hyperRepository: HyperRepository
) {
    fun getHypers(index: Int) : Hyper {
        return hyperRepository.getHypers(index)
    }
}