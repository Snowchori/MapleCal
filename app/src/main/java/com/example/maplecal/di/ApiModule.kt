package com.example.maplecal.di

import androidx.compose.ui.unit.Constraints
import com.example.maplecal.BuildConfig
import com.example.maplecal.ExpService
import com.example.maplecal.RetrofitClient
import com.example.maplecal.data.ExpRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient.Builder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://wachan.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideExpService(retrofit: Retrofit): ExpService {
        return retrofit.create(ExpService::class.java)
    }

    @Singleton
    @Provides
    fun provideExpRemoteDataSource(expService: ExpService) : ExpRemoteDataSource {
        return ExpRemoteDataSource(expService)
    }
}