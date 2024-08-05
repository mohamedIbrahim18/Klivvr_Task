package com.example.data.repositoryImpl

import com.example.data.datasource.CityDataSource
import com.example.domain.model.City
import com.example.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val cityDataSource: CityDataSource
) : CityRepository {
    override suspend fun getAllCities(): List<City> {
        return cityDataSource.getAllCities()
    }
}