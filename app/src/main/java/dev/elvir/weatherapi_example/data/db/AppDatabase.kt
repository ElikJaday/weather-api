package dev.elvir.weatherapi_example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.elvir.weatherapi_example.data.db.dao.CitiesDao
import dev.elvir.weatherapi_example.domain.model.CityModel

@Database(
    entities = [CityModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCityDao(): CitiesDao
}