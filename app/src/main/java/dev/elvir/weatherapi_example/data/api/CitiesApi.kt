package dev.elvir.weatherapi_example.data.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url
import dev.elvir.weatherapi_example.domain.model.City

interface CitiesApi {
    @GET
    fun getSearchedCities(@Url url: String):Observable<List<City>>

}