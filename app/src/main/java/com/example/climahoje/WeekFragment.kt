package com.example.climahoje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.climahoje.adapter.WeekAdapter
import com.example.climahoje.api.ApiService.Companion.city
import com.example.climahoje.databinding.FragmentWeekBinding


class WeekFragment : Fragment() {

    private val mainViewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentWeekBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeekBinding.inflate(layoutInflater, container, false)

        var cityWeek = city

        mainViewModel.getDataWeek()

        val mAdapter = WeekAdapter()
        binding.rvlWeek.layoutManager = LinearLayoutManager(context)
        binding.rvlWeek.adapter = mAdapter
        binding.rvlWeek.setHasFixedSize(true)

        mainViewModel.myWeatherWeekResponse.observe(viewLifecycleOwner) { response ->
            if (response != null) {
                mAdapter.setDataWeek(response.list)
            }
        }

        binding.imgBack.setOnClickListener {
            findNavController().navigate(R.id.action_weekFragment_to_homeFragment)
        }

        return binding.root
    }


}