package dev.elvir.weatherapi_example.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.elvir.weatherapi_example.data.db.WeatherDao
import dev.elvir.weatherapi_example.data.db.config.WeatherDB
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): WeatherDB {
        return Room
            .databaseBuilder(application, WeatherDB::class.java, "db-expka")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(db: WeatherDB): WeatherDao {
        return db.getWeatherDao()
    }
}