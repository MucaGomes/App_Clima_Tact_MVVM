package com.example.climahoje.adapter

import Root
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.climahoje.databinding.CardWeekLayoutBinding
import java.util.*

class WeekAdapter : RecyclerView.Adapter<WeekAdapter.WeekViewHolder>() {

    private var listWeatherWeek = emptyList<Root>()

    class WeekViewHolder(val binding: CardWeekLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        return WeekViewHolder(CardWeekLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        val data = listWeatherWeek[position]

            holder.binding.txtTemp.text = data.list.get(position).main.temp.toString() + "ºC"
            holder.binding.txtMaxTemp.text =
                "max: " + data.list.get(position).main.tempMax.toString() + "ºC"
            holder.binding.txtMinTemp.text =
                "min: " + data.list.get(position).main.tempMin.toString() + "ºC"
            holder.binding.txtStatus.text = data.list.get(position).weather.get(position).description

            var d = Date(data.list[position].dt * 1000)

            when (d.day) {
                1 -> holder.binding.txtDia.text = "Seg"

                2 -> holder.binding.txtDia.text = "Ter"

                3 -> holder.binding.txtDia.text = "Quar"

                4 -> holder.binding.txtDia.text = "Quin"

                5 -> holder.binding.txtDia.text = "Sex"

                6 -> holder.binding.txtDia.text = "Sáb"

                7 -> holder.binding.txtDia.text = "Dom"

            }
    }

    override fun getItemCount(): Int {
        return listWeatherWeek.size
    }

    fun setDataWeek(list: Root) {
        listWeatherWeek = listOf(list)
        notifyDataSetChanged()
    }
}