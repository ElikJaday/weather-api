package dev.elvir.weatherapi_example.domain.model.forecast


import com.google.gson.annotations.SerializedName
import dev.elvir.weatherapi_example.domain.model.forecast.Current
import dev.elvir.weatherapi_example.domain.model.forecast.Daily
import dev.elvir.weatherapi_example.domain.model.forecast.Hourly
import dev.elvir.weatherapi_example.domain.model.forecast.Minutely

data class WeekForecast(
    @SerializedName("current")
    val current: Current,
    @SerializedName("daily")
    val daily: List<Daily>,
    @SerializedName("hourly")
    val hourly: List<Hourly>,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("minutely")
    val minutely: List<Minutely>,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int
)