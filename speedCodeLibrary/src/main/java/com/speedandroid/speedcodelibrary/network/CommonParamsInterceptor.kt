package com.speedandroid.speedcodelibrary.network

import okhttp3.Interceptor
import okhttp3.Response

/**添加公共参数*/
class CommonParamsInterceptor(
    private val commonParams: Map<String, String> = mapOf(),
    private val commonHeaders: Map<String, String> = mapOf()
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        commonHeaders.forEach { (key, value) -> requestBuilder.addHeader(key, value) }

        val urlBuilder = chain.request().url.newBuilder()
        commonParams.forEach { (key, value) -> urlBuilder.addQueryParameter(key, value) }
        requestBuilder.url(urlBuilder.build())
        
        return chain.proceed(requestBuilder.build())
    }
}