package com.speedandroid.mylibrary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingViewModel: ViewModel() {
    val text1 = MutableLiveData<String>()

    fun doTest(){
        text1.value = "123"
    }
}