package com.speedandroid.mylibrary.http

data class NetResponse<T>(val errorCode: Int, val errorMsg: String, val data: T)

data class PageInfo<T>(val curPage: Int, val offset: Int, val over: Boolean, val pageCount: Int, val size: Int, val total: Int,val datas:List<T>)