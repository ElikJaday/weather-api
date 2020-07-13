package dev.elvir.weatherapi_example.data.repository

import dev.elvir.weatherapi_example.data.model.WeatherContainer
import io.reactivex.Single

interface RemoteWeatherRepository {

    fun getWeatherByCity(key: String) : Single<WeatherContainer>
}