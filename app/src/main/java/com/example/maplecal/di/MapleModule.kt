package com.example.maplecal.di

import com.example.maplecal.data.GrowthRepositoryImpl
import com.example.maplecal.data.HyperRepositoryImpl
import com.example.maplecal.data.ParkRepositoryImpl
import com.example.maplecal.data.SymbolRepositoryImpl
import com.example.maplecal.domain.GrowthRepository
import com.example.maplecal.domain.HyperRepository
import com.example.maplecal.domain.ParkRepository
import com.example.maplecal.domain.SymbolRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class MapleModule {

    @Singleton
    @Binds
    abstract fun bindSymbolRepository(impl: SymbolRepositoryImpl): SymbolRepository

    @Singleton
    @Binds
    abstract fun bindParkRepository(impl: ParkRepositoryImpl): ParkRepository

    @Singleton
    @Binds
    abstract fun bindHyperRepository(impl: HyperRepositoryImpl): HyperRepository

    @Singleton
    @Binds
    abstract fun bindGrowthRepository(impl: GrowthRepositoryImpl): GrowthRepository
}