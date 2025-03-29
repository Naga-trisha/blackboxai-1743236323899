package com.example.myapp.di

import com.example.myapp.data.repositories.CounterRepository
import com.example.myapp.data.repositories.CounterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCounterRepository(): CounterRepository {
        return CounterRepositoryImpl()
    }
}
