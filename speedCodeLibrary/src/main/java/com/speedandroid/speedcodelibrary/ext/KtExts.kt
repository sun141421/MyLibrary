package com.speedandroid.speedcodelibrary.ext

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import androidx.core.view.postDelayed
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.math.ceil


fun Context.layoutInflater() = LayoutInflater.from(this)

/** * dp转px * */
val Float.dp: Int
    get() {
        val displayMetrics = Resources.getSystem().displayMetrics
        return ceil(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)).toInt()
    }

/**sp转px*/
val Float.sp: Int
    get() {
        val displayMetrics = Resources.getSystem().displayMetrics
        return ceil(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, displayMetrics)).toInt()
    }

/** * dp转px * */
val Int.dp: Int
    get() {
        return this.toFloat().dp
    }

/**sp转px*/
val Int.sp: Int
    get() {
        return this.toFloat().sp
    }


fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

/**
 * 防抖点击
 * */
fun View.onDebounceClick(disableTime: Long = 300L, onClickListener: OnClickListener) {
    this.setOnClickListener {
        this.isClickable = false
        postDelayed(disableTime) { this.isClickable = true }
        onClickListener.onClick(this)
    }
}

/**加载图片*/
fun ImageView.loadImage(imgUrl: String, placeholder: Int?, errorImg: Int?) {
    val options = RequestOptions()
    placeholder?.let { options.placeholder(placeholder) }
    errorImg?.let { options.error(errorImg) }
    Glide.with(this).load(imgUrl).apply(options).into(this)
}

fun Context.asActivity(): Activity? {
    if (this is Activity) {
        return this
    }

    var baseContext = this
    while (baseContext is ContextWrapper) {
        baseContext = baseContext.baseContext
        if (baseContext is Activity) {
            return baseContext
        }
    }
    return null
}

fun <R, T1, T2> LiveData<T1>.zip(lD2: LiveData<T2>, block: (T1?, T2?) -> R): MediatorLiveData<R> {
    return LiveDatas.zip(this, lD2, block)
}

fun <R, T1, T2, T3> LiveData<T1>.zip(lD2: LiveData<T2>, lD3: LiveData<T3>, block: (T1?, T2?, T3?) -> R): MediatorLiveData<R> {
    return LiveDatas.zip(this, lD2, lD3, block)
}

fun <R, T1, T2, T3, T4> LiveData<T1>.zip(
    lD2: LiveData<T2>,
    lD3: LiveData<T3>,
    lD4: LiveData<T4>,
    block: (T1?, T2?, T3?, T4?) -> R
): MediatorLiveData<R> {
    return LiveDatas.zip(this, lD2, lD3, lD4, block)
}

