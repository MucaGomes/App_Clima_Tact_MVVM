package com.example.climahoje

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.climahoje.adapter.HomeAdapter
import com.example.climahoje.api.ApiService.Companion.city
import com.example.climahoje.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        mainViewModel.getData()

        // Configurando o adapter
        val mAdapter = HomeAdapter()
        binding.rvlHomeWeather.layoutManager = LinearLayoutManager(context)
        binding.rvlHomeWeather.adapter = mAdapter
        binding.rvlHomeWeather.setHasFixedSize(true)

        binding.btSearch.setOnClickListener {
            try {
                val text = binding.edtCidade.text.toString()
                city = text

                mainViewModel.getData()
            }catch (e: Exception){
                Log.d("Erro inesperado", e.message.toString())
            }
        }

        mainViewModel.myWeatherResponse.observe(viewLifecycleOwner) { response ->
            Log.d("Requisicao", response.body().toString())
            if (response != null){
                mAdapter.setData(response.body()!!)
            }
        }

        binding.imgNextWeek.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_weekFragment)
        }

        return binding.root
    }
}
