package dev.elvir.weatherapi_example.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.elvir.weatherapi_example.App
import dev.elvir.weatherapi_example.R
import dev.elvir.weatherapi_example.data.model.WeatherContainer
import dev.elvir.weatherapi_example.utils.NetWorkInfoUtility
import kotlinx.android.synthetic.main.fragment_home.*
import java.net.InetAddress
import javax.inject.Inject

public class HomeFragment : Fragment(), HomeContract.View {
    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var presenter: HomeContract.Presenter

    private fun injectDependency() =
        (context?.applicationContext as App).getApplicationComponent().also { it.inject(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        presenter.attach(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadMessage()
    }

    override fun showMessage(weatherContainer: WeatherContainer) {
       txt_message.text = weatherContainer.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
