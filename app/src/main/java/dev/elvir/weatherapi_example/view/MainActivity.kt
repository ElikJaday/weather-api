package dev.elvir.weatherapi_example.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.elvir.weatherapi_example.R
import dev.elvir.weatherapi_example.ext.addFragment
import dev.elvir.weatherapi_example.view.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showHomeFragment()
    }

    private fun showHomeFragment() {
        addFragment(HomeFragment(), R.id.container)
    }
}