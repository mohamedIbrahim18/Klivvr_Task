package com.example.domain.usecase

import com.example.domain.model.City
import com.example.domain.repository.CityRepository
import javax.inject.Inject

class GetAllCitiesUseCase @Inject constructor(
    private val repo :CityRepository
) {
    suspend operator fun invoke(): List<City> {
        return repo.getAllCities()
    }
}