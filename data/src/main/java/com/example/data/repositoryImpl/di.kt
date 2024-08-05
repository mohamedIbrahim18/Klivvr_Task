package com.example.data.repositoryImpl

import com.example.domain.repository.CityRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
    @Binds
    abstract fun provideCityRepository(cityRepositoryImpl: CityRepositoryImpl): CityRepository
}