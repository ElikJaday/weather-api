package dev.elvir.weatherapi_example.ui.addcity

import android.widget.EditText
import dev.elvir.weatherapi_example.domain.model.City

interface AddCityMvpView{
    fun showCities(cities:List<City>)
    fun showMessage(message:String)
    fun onError(errorMessage:String)

}

interface AddCityMvpPresenter{
    fun addCity(city: City)
    fun initSearch(editText: EditText)
    fun onAttach(view: AddCityMvpView)
    fun onDetach()

}