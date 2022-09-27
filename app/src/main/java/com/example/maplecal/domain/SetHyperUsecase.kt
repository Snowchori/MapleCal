package com.example.maplecal.domain

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SetHyperUsecase @Inject constructor(
    private val hyperRepository: HyperRepository
) {
    fun setHypersCount(index: Int, count: String) {
        hyperRepository.setHypersCount(index, count)
    }

    fun setInit() {
        hyperRepository.setInit()
    }
}