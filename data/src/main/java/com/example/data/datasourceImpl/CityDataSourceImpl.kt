package com.example.data.datasourceImpl

import android.content.Context
import android.util.Log
import com.example.data.R
import com.example.data.datasource.CityDataSource
import com.example.data.model.CityDto
import com.example.data.model.toDomain
import com.example.domain.model.City
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import javax.inject.Inject

class CityDataSourceImpl @Inject constructor(private val context: Context) : CityDataSource {
    override suspend fun getAllCities(): List<City> {
        val inputStream = context.resources.openRawResource(R.raw.cities)
        val json = InputStreamReader(inputStream).readText()

        // Convert JSON string to a list of CityDto
        val cityDtoType = object : TypeToken<List<CityDto>>() {}.type
        val cityDtoList: List<CityDto> = Gson().fromJson(json, cityDtoType)
//        cityDtoList.forEach {
//            Log.d("CityDto", "Parsed CityDto: $it")
//        }

        // Map CityDto list to City list
        return cityDtoList.map {
            it.toDomain()
        }
    }
}