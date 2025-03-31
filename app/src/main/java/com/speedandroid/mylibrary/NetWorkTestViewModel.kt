package com.speedandroid.mylibrary

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.speedandroid.mylibrary.http.AppRetrofitClient
import com.speedandroid.mylibrary.http.DataItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NetWorkTestViewModel : ViewModel() {
    private val apiService by lazy { AppRetrofitClient.apiService }
    private val _stateFlow = MutableStateFlow<List<DataItem>>(listOf())
    val stateFlow = _stateFlow.asStateFlow()

    fun getContent() {
        viewModelScope.launch {
            val response = apiService.getIndexContent()
            Log.e("test", "response: $response")
            _stateFlow.value = response.data
        }
    }
}