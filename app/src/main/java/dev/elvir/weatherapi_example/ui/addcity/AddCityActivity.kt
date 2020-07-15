package dev.elvir.weatherapi_example.ui.addcity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.weatherapi_example.R
import dev.elvir.weatherapi_example.WeatherApp
import dev.elvir.weatherapi_example.di.component.DaggerActivityComponent
import dev.elvir.weatherapi_example.di.module.ActivityModule
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_add_city.*
import dev.elvir.weatherapi_example.domain.model.City
import javax.inject.Inject

class AddCityActivity : AppCompatActivity(), AddCityMvpView {
    @Inject
    lateinit var presenter: AddCityMvpPresenter
    private lateinit var disposable: Disposable
    lateinit var citiesAdapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        presenter.onAttach(this)
        setContentView(R.layout.activity_add_city)
        setUp()

    }


    private fun setUp() {
        citiesAdapter = CitiesAdapter { city -> presenter.addCity(city) }
        initToolbar()
        presenter.initSearch(edit_name)


    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun injectDependencies() {
        DaggerActivityComponent
            .builder()
            .appComponent((application as WeatherApp).appComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }

    override fun showCities(cities: List<City>) {
        cities_rv.apply {
            layoutManager =
                LinearLayoutManager(this@AddCityActivity, RecyclerView.VERTICAL, false)
            cities_rv.adapter = citiesAdapter
        }
        citiesAdapter.setList(cities)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }

    override fun onError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}