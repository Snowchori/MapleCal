package com.chori.maplecal.di

import com.chori.maplecal.data.GrowthRepositoryImpl
import com.chori.maplecal.data.HyperRepositoryImpl
import com.chori.maplecal.data.ParkRepositoryImpl
import com.chori.maplecal.data.SymbolRepositoryImpl
import com.chori.maplecal.domain.GrowthRepository
import com.chori.maplecal.domain.HyperRepository
import com.chori.maplecal.domain.ParkRepository
import com.chori.maplecal.domain.SymbolRepository
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