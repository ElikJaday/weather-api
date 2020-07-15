package dev.elvir.weatherapi_example.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.elvir.weatherapi_example.data.db.AppDatabase
import dev.elvir.weatherapi_example.data.db.dao.CitiesDao
import dev.elvir.weatherapi_example.data.repository.*
import dev.elvir.weatherapi_example.di.qualifier.ApplicationContext
import javax.inject.Singleton

@Module
class AppModule(private val context: Application) {
    private var appDatabase: AppDatabase

    companion object {
        const val preferencesName = "PREF_NAME"
        const val db_name = "database1"
    }

    init {
        appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, db_name)
            .allowMainThreadQueries()
            .build()
    }


    @Provides
    @ApplicationContext
    fun provideAppContext(): Context = context

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        return appDatabase
    }


    @Provides
    @Singleton
    fun getCitiesDao(appDatabase: AppDatabase): CitiesDao {
        return appDatabase.getCityDao()
    }

    @Provides
    @Singleton
    fun getSharedPreferences(): SharedPreferences =
        context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun getPreferences(dataPreferences: DataPreferencesImpl): DataPreferences = dataPreferences

    @Provides
    @Singleton
    fun getWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository =
        weatherRepositoryImpl

    @Provides
    @Singleton
    fun getCitiesRemoteRepository(citiesRepository: CitiesRemoteRepositoryImpl): CitiesRemoteRepository =
        citiesRepository

    @Provides
    @Singleton
    fun getLocalCitiesRepository(localCitiesRepository: CitiesLocalRepositoryImpl): CitiesLocalRepository =
        localCitiesRepository


}