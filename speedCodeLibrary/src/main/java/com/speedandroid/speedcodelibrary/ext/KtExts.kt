package com.speedandroid.speedcodelibrary.ext

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.math.ceil


fun Context.layoutInflater() = LayoutInflater.from(this)

/**
 * dp转px
 * @param context 不传使用默认,用于有设置过固定分辨率等等的情况
 * */
fun Int.dp(context: Context? = null): Int {
    val resource = context?.resources ?: Resources.getSystem()
    return ceil(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), resource.displayMetrics)).toInt()
}

/**
 * sp转px
 * @param context 不传使用默认,用于有设置过固定分辨率等等的情况
 * */
fun Int.sp(context: Context? = null): Int {
    val resource = context?.resources ?: Resources.getSystem()
    return ceil(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), resource.displayMetrics)).toInt()
}

fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

