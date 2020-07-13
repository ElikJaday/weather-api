package dev.elvir.weatherapi_example.view.home

import android.annotation.SuppressLint
import dev.elvir.weatherapi_example.data.model.WeatherContainer
import dev.elvir.weatherapi_example.data.repository.LocalWeatherRepository
import dev.elvir.weatherapi_example.data.repository.RemoteWeatherRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


@SuppressLint("CheckResult")
class HomePresenter @Inject constructor(
    val remoteWeatherRepository: RemoteWeatherRepository,
    val localWeatherRepository: LocalWeatherRepository
) : HomeContract.Presenter {
    private val subscriptions = CompositeDisposable()
    private lateinit var view: HomeContract.View

    override fun loadMessage() {
        Observable.mergeDelayError(
            remoteWeatherRepository.getWeatherByCity("")
                .doOnNext { localWeatherRepository.insert(it) }
                .subscribeOn(Schedulers.io())
            , localWeatherRepository.getAllInfo().subscribeOn(Schedulers.io())
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {
                it.printStackTrace()
            })
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: HomeContract.View) {
        this.view = view
    }

    private fun saveData(weatherContainer: WeatherContainer) {
        localWeatherRepository.insert(weatherContainer)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {
                it.printStackTrace()
            })
    }

    private fun getAll() {
        localWeatherRepository.getAllInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                for (item in it) {
                    view.showMessage(item)
                }
            }, {
                it.printStackTrace()
            })
    }

}