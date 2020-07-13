package dev.elvir.weatherapi_example.view.home

import dev.elvir.weatherapi_example.data.model.WeatherContainer
import dev.elvir.weatherapi_example.view.base.BaseContract

class HomeContract {

    interface View : BaseContract.View {
        fun showMessage(weatherContainer: WeatherContainer)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadMessage()
    }
}