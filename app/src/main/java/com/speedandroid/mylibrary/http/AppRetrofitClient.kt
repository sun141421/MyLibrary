package com.speedandroid.mylibrary.http

import com.speedandroid.speedcodelibrary.network.CommonParamsInterceptor
import com.speedandroid.speedcodelibrary.network.MultiHostInterceptor
import com.speedandroid.speedcodelibrary.network.RetrofitClient
import retrofit2.Retrofit

object AppRetrofitClient {

    private fun newInstance(): Retrofit {
        val commonParams = mapOf(
            "time" to System.currentTimeMillis().toString(),
            "token" to "12345678",
        )
        val commonHeaders = mapOf(
            "appVersion" to "1.0.0",
            "uid" to "uid_1234",
        )
        val commonInterceptor = CommonParamsInterceptor(commonParams, commonHeaders)
        return RetrofitClient.newClient(ApiUrls.BASE_URL, listOf(commonInterceptor, MultiHostInterceptor()))
    }

    private val retrofit: Retrofit by lazy { newInstance() }

    val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }

}