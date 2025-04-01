package com.speedandroid.speedcodelibrary.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * 多个host的拦截器
 *
 * */
class MultiHostInterceptor : Interceptor {
    companion object {
        const val HEADER_ACT_HOST = "Act_Host"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val actHost = chain.request().header(HEADER_ACT_HOST)
        val request = if (actHost.isNullOrEmpty()) {
            chain.request()
        } else {
            val newUrl = chain.request().url.newBuilder().host(actHost).build()
            chain.request().newBuilder().url(newUrl).build()
        }
        return chain.proceed(request)
    }
}