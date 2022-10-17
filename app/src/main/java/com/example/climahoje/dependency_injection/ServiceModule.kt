package com.example.climahoje.dependency_injection

import com.example.climahoje.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun ProvideRepository(): Repository {
        return Repository()
    }
}