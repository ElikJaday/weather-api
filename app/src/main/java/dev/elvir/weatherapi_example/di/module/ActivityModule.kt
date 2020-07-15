package dev.elvir.weatherapi_example.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dev.elvir.weatherapi_example.di.ActivityScope
import dev.elvir.weatherapi_example.domain.interactor.AddCityInteractor
import dev.elvir.weatherapi_example.domain.interactor.ForecastInteractor
import dev.elvir.weatherapi_example.domain.interactor.MainInteractor
import dev.elvir.weatherapi_example.domain.interactor.UseCase


@Module
class ActivityModule(private val context: AppCompatActivity) {

    @ActivityScope
    @Provides
    fun provideActivityContext(): Context = context

    @Provides
    @ActivityScope
    fun getMainInteractor(mainInteractor: MainInteractor): UseCase {
        return mainInteractor
    }

    @Provides
    @ActivityScope
    fun getAddCityInteractor(addCityInteractor: AddCityInteractor): UseCase {
        return addCityInteractor
    }

    @Provides
    @ActivityScope
    fun getForecastInteractor(forecastInteractor: ForecastInteractor): UseCase {
        return forecastInteractor
    }



}