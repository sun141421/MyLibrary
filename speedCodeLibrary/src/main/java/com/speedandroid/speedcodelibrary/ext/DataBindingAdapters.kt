package com.speedandroid.speedcodelibrary.ext

import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.databinding.BindingAdapter

@BindingAdapter("goneWhenEmpty")
fun bindingGoneWhenEmpty(view: View, list: List<Any>?) {
    view.isGone = list.isNullOrEmpty()
}

@BindingAdapter("goneWhenEmpty")
fun bindingGoneWhenEmpty(view: View, text: CharSequence?) {
    view.isGone = text.isNullOrEmpty()
}

@BindingAdapter("invisibleWhenEmpty")
fun bindingInvisibleWhenEmpty(view: View, list: List<Any>?) {
    view.isInvisible = list.isNullOrEmpty()
}

@BindingAdapter("invisibleWhenEmpty")
fun bindingInvisibleWhenEmpty(view: View, text: CharSequence?) {
    view.isInvisible = text.isNullOrEmpty()
}

@BindingAdapter("onDebounceClick")
fun bindingOnDebounceClick(view: View, clickListener: OnClickListener) {
    view.onDebounceClick(clickListener)
}

@BindingAdapter(value = ["imgUrl", "placeholder", "errorImg"], requireAll = false)
fun bindingImgUrl(imageView: ImageView, imgUrl: String, placeholder: Int?, errorImg: Int?) {
    imageView.loadImage(imgUrl, placeholder, errorImg)
}




