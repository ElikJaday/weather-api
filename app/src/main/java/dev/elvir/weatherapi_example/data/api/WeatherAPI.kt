package dev.elvir.weatherapi_example.data.api

import dev.elvir.weatherapi_example.data.model.WeatherContainer
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("data/2.5/weather")
    fun getWeatherByCity(@Query("q") city: String,
                 @Query("units") units: String,
                 @Query("appid") appid: String
    ): Observable<WeatherContainer>
}