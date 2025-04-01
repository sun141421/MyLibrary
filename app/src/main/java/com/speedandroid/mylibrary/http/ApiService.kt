package com.speedandroid.mylibrary.http

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET("/banner/json")
    suspend fun getBannerContent(): NetResponse<List<DataItem>>

    @POST("/article/query/0/json")
    @FormUrlEncoded
    suspend fun search(@Field("k") key: String, @Query("page") page: Int, @Query("page_size") pageSize: Int): NetResponse<PageInfo<SearchResultDTO>>
}