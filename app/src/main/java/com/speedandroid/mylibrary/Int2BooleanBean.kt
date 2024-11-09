package com.speedandroid.mylibrary

import com.google.gson.annotations.JsonAdapter
import com.speedandroid.speedcodelibrary.ext.IntToBooleanTypeAdapter


val Test_JSON = "{'isFree':0 , 'name':'你好'}"

data class Int2BooleanBean(
    @JsonAdapter(IntToBooleanTypeAdapter::class)
    val isFree:Boolean,
    val name:String)
