package com.speedandroid.mylibrary

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.speedandroid.mylibrary.http.AppRetrofitClient
import com.speedandroid.mylibrary.http.DataItem
import com.speedandroid.mylibrary.http.SearchResultDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NetWorkTestViewModel : ViewModel() {
    private val apiService by lazy { AppRetrofitClient.apiService }
    private val _stateFlow = MutableStateFlow<List<DataItem>>(listOf())
    val stateFlow = _stateFlow.asStateFlow()

    private val _state2Flow = MutableStateFlow<List<SearchResultDTO>>(listOf())
    val state2Flow = _state2Flow.asStateFlow()

    fun getContent() {
        viewModelScope.launch {
            val response = apiService.getBannerContent()
            Log.e("test", "response: $response")
            _stateFlow.value = response.data
        }
    }

    fun postSearch(key:String){
        viewModelScope.launch {
            val response = apiService.search(key,1,10)
            Log.e("test", "response: $response")
            _state2Flow.value = response.data.datas
        }
    }
}