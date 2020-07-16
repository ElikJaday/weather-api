package dev.elvir.weatherapi_example.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.weatherapi_example.R
import dev.elvir.weatherapi_example.domain.model.CityModel
import kotlinx.android.synthetic.main.add_city_item.view.*


class LocalCitiesAdapter(val onItemClick: (CityModel) -> Unit) :
    RecyclerView.Adapter<LocalCitiesAdapter.LocalCitiesViewHolder>() {
    private val mCities = mutableListOf<CityModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocalCitiesViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.cities_list_item, parent, false)
        return LocalCitiesViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mCities.size
    }

    override fun onBindViewHolder(holder: LocalCitiesViewHolder, position: Int) {
        holder.bind(mCities[position], onItemClick)
    }

    fun setList(cities: List<CityModel>) {
        mCities.clear()
        mCities.addAll(cities)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        mCities.removeAt(position)
        notifyItemRemoved(position)
    }

    fun getData(): List<CityModel> {
        return mCities
    }


    inner class LocalCitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(city: CityModel, onItemClick: (CityModel) -> Unit) {
            itemView.city_name.text = city.displayName
            itemView.setOnClickListener {
                onItemClick(city)
            }
        }

    }

}