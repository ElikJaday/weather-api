package dev.elvir.weatherapi_example.domain.interactor

import dev.elvir.weatherapi_example.data.repository.CitiesLocalRepository
import dev.elvir.weatherapi_example.domain.model.CityModel
import javax.inject.Inject

class MainInteractor @Inject constructor(private val citiesLocalRepository: CitiesLocalRepository) :
    UseCase {
    fun getLocalCities() = citiesLocalRepository.getAllCities()

    fun removeItem(cityModel: CityModel) = citiesLocalRepository.removeCity(cityModel)

}