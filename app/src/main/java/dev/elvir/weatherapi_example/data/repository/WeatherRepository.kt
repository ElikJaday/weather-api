package dev.elvir.weatherapi_example.data.repository

import io.reactivex.Single
import retrofit2.Retrofit
import dev.elvir.weatherapi_example.data.api.OpenWeatherApi
import dev.elvir.weatherapi_example.domain.model.forecast.WeekForecast
import dev.elvir.weatherapi_example.utills.Constants
import javax.inject.Inject

interface WeatherRepository {

    fun getWeekForecast(latitude:String,longitude:String):Single<WeekForecast>



}

class WeatherRepositoryImpl @Inject constructor(val client: Retrofit) : WeatherRepository {
    override fun getWeekForecast(latitude:String,longitude:String): Single<WeekForecast> {
        return client
            .create(OpenWeatherApi::class.java)
            .getWeeklyCityForecast(latitude,longitude, Constants.API_KEY)
    }

}