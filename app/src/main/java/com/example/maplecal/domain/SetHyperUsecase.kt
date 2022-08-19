package com.example.maplecal.domain

class SetHyperUsecase(
    private val hyperRepository: HyperRepository
)  {
    fun setHypersCount(index: Int, count: Int) {
        hyperRepository.setHypersCount(index, count)
    }
}