package dev.elvir.weatherapi_example.data.repository

import dev.elvir.weatherapi_example.data.api.WeatherAPI
import dev.elvir.weatherapi_example.data.model.WeatherContainer
import io.reactivex.Single
import javax.inject.Inject

class RemoteWeatherRepositoryImpl @Inject constructor(
    val weatherAPI: WeatherAPI
) : RemoteWeatherRepository {

    override fun getWeatherByCity(key: String): Single<WeatherContainer> {
        return weatherAPI.getWeatherByCity("moscow", "metric", "1a27d948cbbe097a40c7017f67829705")
    }

}