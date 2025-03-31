package com.speedandroid.mylibrary.http

data class NetResponse<T>(val errorCode: Int, val errorMsg: String, val data: T)
