package com.speedandroid.speedcodelibrary.ext

import android.graphics.drawable.Drawable
import android.widget.TextView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

/**
 * 加载 CompoundDrawable
 * @param position 取值[LEFT],[TOP]等
 * */
class CompoundDrawableTarget(private val view: TextView, private val position: Int, width: Int, height: Int) : CustomTarget<Drawable>(width, height) {
    companion object {
        const val LEFT: Int = 0
        const val TOP: Int = 1
        const val RIGHT: Int = 2
        const val BOTTOM: Int = 3
    }

    override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
        setCompoundDrawable(resource)
    }

    override fun onLoadCleared(placeholder: Drawable?) {
        setCompoundDrawable(placeholder)
    }

    private fun setCompoundDrawable(drawable: Drawable?) {
        val drawables = view.compoundDrawables.copyOf()
        drawables[position] = drawable
        view.setCompoundDrawablesWithIntrinsicBounds(drawables[LEFT], drawables[TOP], drawables[RIGHT], drawables[BOTTOM])

    }
}

fun RequestBuilder<Drawable>.into(view: TextView, position: Int, width: Int, height: Int) {
    this.into(CompoundDrawableTarget(view, position, width, height))
}