package com.speedandroid.mylibrary.http

import com.speedandroid.speedcodelibrary.network.MultiHostInterceptor

object ApiUrls {
    const val BASE_URL ="https://www.wanandroid.com"

    /**另一个host, 冒号左右不要有空格*/
    const val OTHER_HOST_HEADER ="${MultiHostInterceptor.HEADER_ACT_HOST}:www.wanandroid2.com"
}