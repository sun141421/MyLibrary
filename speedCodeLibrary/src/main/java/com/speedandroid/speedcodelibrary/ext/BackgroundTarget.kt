package com.speedandroid.speedcodelibrary.ext

import android.graphics.drawable.Drawable
import android.view.View
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition

/**加载背景*/
class BackgroundTarget(view: View) : CustomViewTarget<View, Drawable>(view) {
    override fun onLoadFailed(errorDrawable: Drawable?) {
        view.background = errorDrawable
    }

    override fun onResourceCleared(placeholder: Drawable?) {
        view.background = placeholder
    }

    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
        view.background = resource
    }
}

fun  RequestBuilder<Drawable>.intoBg(view: View){
    this.into(BackgroundTarget(view))
}