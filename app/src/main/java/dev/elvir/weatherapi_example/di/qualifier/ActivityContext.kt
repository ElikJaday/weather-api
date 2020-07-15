package dev.elvir.weatherapi_example.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext {
}