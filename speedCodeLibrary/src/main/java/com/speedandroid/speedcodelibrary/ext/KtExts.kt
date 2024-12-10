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
fun View.onDebounceClick(onClickListener: OnClickListener) {
    this.setOnClickListener {
        this.isClickable = false
        postDelayed(300) { this.isClickable = true }
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