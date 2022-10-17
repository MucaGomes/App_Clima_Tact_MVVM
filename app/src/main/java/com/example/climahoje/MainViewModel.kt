package com.example.climahoje

import Root
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climahoje.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {

    private var _myWeatherResponse =
        MutableLiveData<Response<Root>>()

    val myWeatherResponse: LiveData<Response<Root>> = _myWeatherResponse

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                val response = repository.getWeatherData()
                _myWeatherResponse.value = response
            }catch (e: Exception){
                Log.d("Erro", e.message.toString())
            }
        }
    }
}