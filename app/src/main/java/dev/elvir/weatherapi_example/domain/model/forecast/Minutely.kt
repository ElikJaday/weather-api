package dev.elvir.weatherapi_example.domain.model.forecast


import com.google.gson.annotations.SerializedName

data class Minutely(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("precipitation")
    val precipitation: Int
)