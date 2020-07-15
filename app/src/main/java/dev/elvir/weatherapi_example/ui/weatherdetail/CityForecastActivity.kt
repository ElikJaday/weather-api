package dev.elvir.weatherapi_example.ui.weatherdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.weatherapi_example.R
import dev.elvir.weatherapi_example.WeatherApp
import dev.elvir.weatherapi_example.di.component.DaggerActivityComponent
import dev.elvir.weatherapi_example.di.module.ActivityModule
import kotlinx.android.synthetic.main.activity_city_weather.*

import dev.elvir.weatherapi_example.domain.model.CityModel
import dev.elvir.weatherapi_example.domain.model.forecast.WeekForecast
import javax.inject.Inject

class CityForecastActivity : AppCompatActivity(), CityForecastMvpView {
    companion object {
        const val CITY_KEY = "citykey"
    }
    lateinit var cityModel: CityModel

    @Inject
    lateinit var presenter: CityForecastMvpPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        cityModel = intent.getSerializableExtra(CITY_KEY) as CityModel
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_weather)
        setUp()


    }

    private fun setUp() {
        presenter.onAttach(this)
        presenter.getCityForecast(cityModel.latitude,cityModel.longitude)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun showWeekForecast(weekForecast: WeekForecast?) {
        weekForecast?.let {
            current_temp.text = "${it.current.temp} °C"
            weekForecast_Rv.apply {
                layoutManager =
                    LinearLayoutManager(this@CityForecastActivity, RecyclerView.HORIZONTAL, false)
                weekForecast_Rv.adapter = HourlyForecastAdapter(weekForecast.hourly)
            }
        }
    }

    override fun onError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progress_bar?.visibility = View.VISIBLE

    }

    override fun hideLoading() {
        progress_bar?.visibility = View.INVISIBLE
    }

    private fun injectDependencies() {
        DaggerActivityComponent
            .builder()
            .appComponent((application as WeatherApp).appComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }
}