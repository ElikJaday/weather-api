package dev.elvir.weatherapi_example.di.component

import dagger.Component
import dev.elvir.weatherapi_example.App
import dev.elvir.weatherapi_example.di.module.*
import dev.elvir.weatherapi_example.view.home.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class,
        DataBaseModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ApplicationModule::class
    ]
)
interface AppComponent {

    fun inject(application: App)
    fun inject(fragment: HomeFragment)
}