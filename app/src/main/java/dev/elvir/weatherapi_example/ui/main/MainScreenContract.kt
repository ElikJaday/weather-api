package dev.elvir.weatherapi_example.ui.main

import dev.elvir.weatherapi_example.domain.model.CityModel

interface MainScreenMvpView{
    fun showCities(cities:List<CityModel>)


}

interface MainScreenMvpPresenter{
    fun onAttach(mainScreenMvpView: MainScreenMvpView)
    fun onDetach()
    fun getLocalCities()
    fun removeItem(cityModel: CityModel)

}