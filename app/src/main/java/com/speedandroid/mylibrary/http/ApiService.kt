package com.speedandroid.mylibrary.http

import retrofit2.http.GET

interface ApiService {

    @GET("/banner/json")
    suspend fun getIndexContent(): NetResponse<List<DataItem>>
}