package com.example.climahoje.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.climahoje.R
import com.example.climahoje.databinding.CardWeekLayoutBinding
import java.text.SimpleDateFormat
import java.util.*

class WeekAdapter : RecyclerView.Adapter<WeekAdapter.WeekViewHolder>() {

    private var listWeatherWeek = emptyList<com.example.climahoje.Model.List>()

    class WeekViewHolder(val binding: CardWeekLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        return WeekViewHolder(CardWeekLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        //adapter para nossos card na tela de previsao para a semana
        val data = listWeatherWeek[position]

        // aqui é um text de temperatura
        holder.binding.txtTemp.text = data.main.temp.toString() + "ºC"

        holder.binding.txtMaxTemp.text =
            "max: " + data.main.tempMax.toString() + "ºC"

        holder.binding.txtMinTemp.text =
            "min: " + data.main.tempMin.toString() + "ºC"

        holder.binding.txtStatus.text =
            data.weather[0].description.toUpperCase()

        holder.binding.txtHour.text =
            SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault())
                .format(
                    Date(
                        data.dt * 1000))

        val d = Date(data.dt * 1000)

        when (d.day) {
            1 -> holder.binding.txtDia.text = "Seg"

            2 -> holder.binding.txtDia.text = "Ter"

            3 -> holder.binding.txtDia.text = "Quar"

            4 -> holder.binding.txtDia.text = "Quin"

            5 -> holder.binding.txtDia.text = "Sex"

            6 -> holder.binding.txtDia.text = "Sáb"

            7 -> holder.binding.txtDia.text = "Dom"

        }

        when (data.weather[0].main) {
            "Thunderstorm" -> {
                holder.binding.imageStatus.setImageResource(R.drawable.chuva)
            }
            "Rain" -> {
                holder.binding.imageStatus.setImageResource(R.drawable.chuvaleve)
            }
            "Clear" -> {
                holder.binding.imageStatus.setImageResource(R.drawable.sun)
            }
            "Clouds" -> {
                holder.binding.imageStatus.setImageResource(R.drawable.cloudy)
            }
            else -> {
                holder.binding.imageStatus.setImageResource(R.drawable.cloudy)
            }
        }

    }

    override fun getItemCount(): Int {
        return listWeatherWeek.size
    }

    fun setDataWeek(list: List<com.example.climahoje.Model.List>) {
        listWeatherWeek = list
        notifyDataSetChanged()
    }
}