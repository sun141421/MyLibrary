package com.speedandroid.speedcodelibrary.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.WindowInsets
import androidx.core.view.WindowInsetsCompat

/**StatusBar的高度的view*/
class StatusBarStubView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var statusBarHeight: Int = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (statusBarHeight != 0) {
            setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), statusBarHeight)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    override fun onApplyWindowInsets(insets: WindowInsets): WindowInsets {
        val compat = WindowInsetsCompat.toWindowInsetsCompat(insets, this)

        statusBarHeight = compat.getInsets(WindowInsetsCompat.Type.systemBars()).top
        return super.onApplyWindowInsets(insets)
    }

}