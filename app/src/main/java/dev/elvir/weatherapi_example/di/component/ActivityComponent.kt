package dev.elvir.weatherapi_example.di.component

import dagger.Component
import dev.elvir.weatherapi_example.di.ActivityScope
import dev.elvir.weatherapi_example.di.module.ActivityModule
import dev.elvir.weatherapi_example.di.module.PresenterModule
import dev.elvir.weatherapi_example.ui.addcity.AddCityActivity
import dev.elvir.weatherapi_example.ui.main.MainScreenActivity
import dev.elvir.weatherapi_example.ui.weatherdetail.CityForecastActivity


@ActivityScope
@Component(modules = [ActivityModule::class, PresenterModule::class],dependencies = [AppComponent::class])
interface ActivityComponent {

    fun inject(mainScreenActivity: MainScreenActivity)
    fun inject(addCityActivity: AddCityActivity)
    fun inject(cityForecastActivity: CityForecastActivity)
}