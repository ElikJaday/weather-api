package dev.elvir.weatherapi_example

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dev.elvir.weatherapi_example.di.component.AppComponent
import dev.elvir.weatherapi_example.di.component.DaggerAppComponent
import dev.elvir.weatherapi_example.di.module.ApplicationModule

class App : Application() {

    lateinit var component: AppComponent

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        setup()
        super.onCreate()
    }

    fun setup() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): AppComponent {
        return component
    }

    companion object {
        lateinit var instance: App private set
    }
}