package dev.elvir.weatherapi_example.ui.weatherdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.weatherapi_example.R
import kotlinx.android.synthetic.main.week_forecast_item.view.*
import dev.elvir.weatherapi_example.domain.model.forecast.Hourly
import dev.elvir.weatherapi_example.utills.CommonUtills

class HourlyForecastAdapter(val data: List<Hourly>) :
    RecyclerView.Adapter<HourlyForecastAdapter.ForecastViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.week_forecast_item, parent, false)
        return ForecastViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(daily: Hourly) {
            itemView.time.text = CommonUtills.getDurationBreakdown(daily.dt)
            itemView.temp.text = daily.temp.toString() + " °C"
        }

    }


}