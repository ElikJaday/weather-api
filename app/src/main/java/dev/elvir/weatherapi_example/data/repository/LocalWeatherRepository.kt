package dev.elvir.weatherapi_example.data.repository

import dev.elvir.weatherapi_example.data.model.WeatherContainer
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface LocalWeatherRepository {
    fun insert(weatherContainer: WeatherContainer):Completable
    fun getAllInfo():Observable<List<WeatherContainer>>
}