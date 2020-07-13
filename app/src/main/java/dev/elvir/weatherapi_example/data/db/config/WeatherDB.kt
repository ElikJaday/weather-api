package dev.elvir.weatherapi_example.data.db.config

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.elvir.weatherapi_example.data.db.WeatherDao
import dev.elvir.weatherapi_example.data.model.WeatherContainer

@Database(entities = [WeatherContainer::class], version = 2,exportSchema = false)
public abstract class WeatherDB() : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao
}