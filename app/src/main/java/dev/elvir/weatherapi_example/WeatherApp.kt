package dev.elvir.weatherapi_example

import android.app.Application
import dev.elvir.weatherapi_example.di.component.AppComponent
import dev.elvir.weatherapi_example.di.component.DaggerAppComponent
import dev.elvir.weatherapi_example.di.module.AppModule

class WeatherApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build().also {
                it.inject(this)
            }
    }
}