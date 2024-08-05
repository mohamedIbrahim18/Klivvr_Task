package com.example.data.model

import com.example.domain.model.Coordinates
import com.google.gson.annotations.SerializedName

data class CoordinatesDto(
    @field:SerializedName("lon")
    val longitude: Double,
    @field:SerializedName("lat")
    val latitude: Double
)


fun CoordinatesDto.toCoordinatesDomain(): Coordinates {
    return Coordinates(
        longitude = longitude,
        latitude = latitude
    )
}