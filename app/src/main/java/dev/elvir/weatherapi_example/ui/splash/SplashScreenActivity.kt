package dev.elvir.weatherapi_example.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.elvir.weatherapi_example.R
import dev.elvir.weatherapi_example.ui.main.MainScreenActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, MainScreenActivity::class.java))
        finish()
    }
}