package com.example.maplecal.di

import com.example.maplecal.data.ParkRepositoryImpl
import com.example.maplecal.data.SymbolRepositoryImpl
import com.example.maplecal.domain.ParkRepository
import com.example.maplecal.domain.SymbolRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class MapleModule {

    @Singleton
    @Binds
    abstract fun bindSymbolRepository(impl: SymbolRepositoryImpl) : SymbolRepository

    @Singleton
    @Binds
    abstract fun bindParkRepository(impl: ParkRepositoryImpl) : ParkRepository
}