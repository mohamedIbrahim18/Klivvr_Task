package com.example.data.model

import com.example.domain.model.City
import com.example.domain.model.Coordinates
import com.google.gson.annotations.SerializedName

data class CityDto(
    @field:SerializedName("country")
    val country: String?,
    @field:SerializedName("name")
    val name: String?,
    @field:SerializedName("_id")
    val id: Int?,
    @field:SerializedName("coord")
    val coordinates: CoordinatesDto?
)


fun CityDto.toDomain(): City {
    return City(
        country = country ?: "",
        name = name ?: "",
        id = id ?:0,
        coordinates = coordinates?.toCoordinatesDomain() ?: Coordinates(0.0,0.0)
    )
}