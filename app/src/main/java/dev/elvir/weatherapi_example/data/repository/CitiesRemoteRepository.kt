package dev.elvir.weatherapi_example.data.repository

import io.reactivex.Observable
import retrofit2.Retrofit
import dev.elvir.weatherapi_example.data.api.CitiesApi
import dev.elvir.weatherapi_example.domain.model.City
import javax.inject.Inject

interface CitiesRemoteRepository {
    fun getSearchedCities(cityName: String?): Observable<List<City>>

}

class CitiesRemoteRepositoryImpl @Inject constructor(val client: Retrofit) :
    CitiesRemoteRepository {

    override fun getSearchedCities(cityName: String?): Observable<List<City>> {
        val url = "https://nominatim.openstreetmap.org/search?q=${cityName}&format=json"
        return client.create(CitiesApi::class.java)
            .getSearchedCities(url)
    }

}