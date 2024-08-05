package com.example.data.datasource

import com.example.domain.model.City

interface CityDataSource {
    suspend fun getAllCities() : List<City>
}