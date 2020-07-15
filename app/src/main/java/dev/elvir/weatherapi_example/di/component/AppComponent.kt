package dev.elvir.weatherapi_example.di.component

import dagger.Component
import dev.elvir.weatherapi_example.WeatherApp
import dev.elvir.weatherapi_example.data.repository.CitiesLocalRepository
import dev.elvir.weatherapi_example.data.repository.CitiesRemoteRepository
import dev.elvir.weatherapi_example.data.repository.DataPreferences
import dev.elvir.weatherapi_example.data.repository.WeatherRepository
import dev.elvir.weatherapi_example.di.module.AppModule
import dev.elvir.weatherapi_example.di.module.NetworkModule

import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(weatherApp: WeatherApp)

    fun getPreferences(): DataPreferences
    fun getWeatherRepository(): WeatherRepository
    fun getRemoteCitiesRepository(): CitiesRemoteRepository
    fun getLocalCitiesRepository(): CitiesLocalRepository
}