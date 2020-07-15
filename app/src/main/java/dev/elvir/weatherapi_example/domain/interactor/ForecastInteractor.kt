package dev.elvir.weatherapi_example.domain.interactor

import io.reactivex.Single
import dev.elvir.weatherapi_example.data.repository.WeatherRepository
import dev.elvir.weatherapi_example.domain.model.forecast.WeekForecast
import javax.inject.Inject

class ForecastInteractor @Inject constructor(private val weatherRepository: WeatherRepository)
    : UseCase {

    fun getCityForecast(lat:String,lon:String):Single<WeekForecast>{
        return weatherRepository.getWeekForecast(lat,lon)
    }
}