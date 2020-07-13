package dev.elvir.weatherapi_example.data.db

import androidx.room.*
import dev.elvir.weatherapi_example.data.model.WeatherContainer
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single


@Dao
interface WeatherDao {

    @Query("SELECT * FROM weathercontainer")
    fun getAll(): Observable<List<WeatherContainer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherContainer: WeatherContainer) : Completable

    @Update
    fun update(weatherContainer: WeatherContainer)

    @Delete
    fun delete(weatherContainer: WeatherContainer)
}