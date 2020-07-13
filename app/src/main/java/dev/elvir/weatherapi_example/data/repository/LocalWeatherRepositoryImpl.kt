package dev.elvir.weatherapi_example.data.repository

import dev.elvir.weatherapi_example.data.db.WeatherDao
import dev.elvir.weatherapi_example.data.model.WeatherContainer
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalWeatherRepositoryImpl @Inject constructor(
    val dao: WeatherDao
) : LocalWeatherRepository {

    override fun insert(weatherContainer: WeatherContainer) : Completable {
      return   dao.insert(weatherContainer)
    }

    override fun getAllInfo(): Single<List<WeatherContainer>> {
        return dao.getAll()
    }

}