package dev.elvir.weatherapi_example.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dev.elvir.weatherapi_example.App
import dev.elvir.weatherapi_example.data.api.WeatherAPI
import dev.elvir.weatherapi_example.data.db.WeatherDao
import dev.elvir.weatherapi_example.data.repository.LocalWeatherRepository
import dev.elvir.weatherapi_example.data.repository.LocalWeatherRepositoryImpl
import dev.elvir.weatherapi_example.data.repository.RemoteWeatherRepository
import dev.elvir.weatherapi_example.data.repository.RemoteWeatherRepositoryImpl
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }


    @Provides
    @Singleton
    fun provideRemoteRepository(weatherAPI: WeatherAPI): RemoteWeatherRepository {
        return RemoteWeatherRepositoryImpl(weatherAPI)
    }

    @Provides
    @Singleton
    fun provideLocalRepository(weatherDao: WeatherDao): LocalWeatherRepository {
        return LocalWeatherRepositoryImpl(weatherDao)
    }


}