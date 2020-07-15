package dev.elvir.weatherapi_example.domain.interactor

import io.reactivex.Completable
import dev.elvir.weatherapi_example.data.repository.CitiesLocalRepository
import dev.elvir.weatherapi_example.data.repository.CitiesRemoteRepository
import dev.elvir.weatherapi_example.domain.model.City
import dev.elvir.weatherapi_example.domain.model.CityModel
import javax.inject.Inject

class AddCityInteractor @Inject constructor(
    private val citiesRemoteRepository: CitiesRemoteRepository,
    private val citiesLocalRepository: CitiesLocalRepository
) : UseCase {

    fun initSearch(name: String?) = citiesRemoteRepository.getSearchedCities(name)

    fun addCity(city: City): Completable {
        return citiesLocalRepository.addCity(CityModel.mapToCityModel(city))
    }

}