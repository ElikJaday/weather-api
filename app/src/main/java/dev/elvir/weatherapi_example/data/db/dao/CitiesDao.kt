package dev.elvir.weatherapi_example.data.db.dao

import androidx.room.*
import io.reactivex.Observable
import dev.elvir.weatherapi_example.domain.model.CityModel

@Dao
interface CitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(cityModel: CityModel)

    @Query("SELECT * from citymodel")
    fun getAllCity(): Observable<List<CityModel>>

    @Delete
    fun removeCity(cityModel: CityModel)
}