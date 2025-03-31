package com.speedandroid.speedcodelibrary.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun newClient(baseUrl: String, interceptors: List<Interceptor> = listOf()): Retrofit {
        val okhttp = OkHttpClient.Builder().apply {
            interceptors.forEach { addInterceptor(it) }
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }.build()
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okhttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}