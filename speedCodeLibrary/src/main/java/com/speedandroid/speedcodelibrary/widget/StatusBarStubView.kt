package com.speedandroid.speedcodelibrary.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.speedandroid.speedcodelibrary.StatusBarUtils

/**StatusBar的高度的view*/
class StatusBarStubView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val statusBarHeight = StatusBarUtils.getStatusBarHeight(context)
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), statusBarHeight)
    }
}