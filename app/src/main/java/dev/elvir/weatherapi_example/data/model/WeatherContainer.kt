package dev.elvir.weatherapi_example.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherContainer(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @Embedded
    var coord: Coord
)

data class Coord(
    var lon: Float,
    var lat: Float
)
