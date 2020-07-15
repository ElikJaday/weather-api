package dev.elvir.weatherapi_example.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.weatherapi_example.di.ActivityScope
import dev.elvir.weatherapi_example.ui.addcity.AddCityMvpPresenter
import dev.elvir.weatherapi_example.ui.addcity.AddCityPresenter
import dev.elvir.weatherapi_example.ui.main.MainScreenMvpPresenter
import dev.elvir.weatherapi_example.ui.main.MainScreenPresenter
import dev.elvir.weatherapi_example.ui.weatherdetail.CityForecastMvpPresenter
import dev.elvir.weatherapi_example.ui.weatherdetail.CityForecastPresenter


@Module
class PresenterModule {

    @Provides
    @ActivityScope
    fun provideMainScreenPresenter(mainScreenPresenter: MainScreenPresenter): MainScreenMvpPresenter =
        mainScreenPresenter

    @Provides
    @ActivityScope
    fun provideAddCityPresenter(addCityPresenter: AddCityPresenter): AddCityMvpPresenter =
        addCityPresenter

    @Provides
    @ActivityScope
    fun provideForecastPresenter(forecastPresenter: CityForecastPresenter): CityForecastMvpPresenter =
        forecastPresenter
}