package dev.elvir.weatherapi_example.di.module

import dagger.Module
import dagger.Provides
import dev.elvir.weatherapi_example.data.repository.LocalWeatherRepository
import dev.elvir.weatherapi_example.data.repository.RemoteWeatherRepository
import dev.elvir.weatherapi_example.view.home.HomeContract
import dev.elvir.weatherapi_example.view.home.HomePresenter

@Module
class FragmentModule {

    @Provides
    fun provideHomePresenter(remoteWeatherRepository: RemoteWeatherRepository,
    localWeatherRepository: LocalWeatherRepository): HomeContract.Presenter {
        return HomePresenter(remoteWeatherRepository,localWeatherRepository)
    }
//
//    @Provides
//    fun provideListPresenter(): ListContract.Presenter {
//        return ListPresenter()
//    }
//
//    @Provides
//    fun provideApiService(): ApiServiceInterface {
//        return ApiServiceInterface.create()
//    }
}