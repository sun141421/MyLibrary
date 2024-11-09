package com.speedandroid.speedcodelibrary.ext

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.math.ceil


fun Context.layoutInflater() = LayoutInflater.from(this)

/** * dp转px * */
val Int.dp: Int
    get() {
        val displayMetrics = Resources.getSystem().displayMetrics
        return ceil(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), displayMetrics)).toInt()
    }

/**sp转px*/
val Int.sp: Int
    get() {
        val displayMetrics = Resources.getSystem().displayMetrics
        return ceil(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this.toFloat(), displayMetrics)).toInt()
    }


fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

