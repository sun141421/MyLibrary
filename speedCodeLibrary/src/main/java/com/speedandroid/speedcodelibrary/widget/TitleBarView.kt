package com.speedandroid.speedcodelibrary.widget

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import com.speedandroid.speedcodelibrary.R
import com.speedandroid.speedcodelibrary.databinding.TitleViewLayoutBinding
import com.speedandroid.speedcodelibrary.ext.asActivity
import com.speedandroid.speedcodelibrary.ext.dp
import com.speedandroid.speedcodelibrary.ext.layoutInflater
import com.speedandroid.speedcodelibrary.ext.onDebounceClick
import com.speedandroid.speedcodelibrary.ext.sp

/**标题栏*/
class TitleBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val viewBinding = TitleViewLayoutBinding.inflate(context.layoutInflater(), this)

    init {
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 48.dp)

        viewBinding.ivLeft.onDebounceClick {
            @Suppress("DEPRECATION")
            context.asActivity()?.onBackPressed()
        }

        with(context.obtainStyledAttributes(attrs, R.styleable.TitleBarView)) {
            val title = getString(R.styleable.TitleBarView_tbv_Title)
            viewBinding.tvTitle.text = title
            val titleSize = getDimensionPixelSize(R.styleable.TitleBarView_tbv_TextSize, 16.sp)
            viewBinding.tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize.toFloat())
            val titleColor = getColor(R.styleable.TitleBarView_tbv_TextColor, Color.BLACK)
            viewBinding.tvTitle.setTextColor(titleColor)

            setLeftIcon(getResourceId(R.styleable.TitleBarView_tbv_LeftIcon, R.drawable.ic_round_arrow_back_30))
            viewBinding.ivLeft.isInvisible = getBoolean(R.styleable.TitleBarView_tbv_HiddeLeftIcon, false)
            setRightIcon(getDrawable(R.styleable.TitleBarView_tbv_RightIcon))

            recycle()
        }


    }

    fun setTitle(title: CharSequence) {
        viewBinding.tvTitle.text = title
    }

    fun setLeftIcon(@DrawableRes resId: Int) {
        val drawable = if (resId == 0) null else AppCompatResources.getDrawable(context, resId)
        setLeftIcon(drawable)
    }

    fun setLeftIcon(drawable: Drawable?) {
        viewBinding.ivLeft.setImageDrawable(drawable)
        viewBinding.ivLeft.isGone = drawable == null
    }

    fun setLeftClickListener(listener: OnClickListener) {
        viewBinding.ivLeft.setOnClickListener(listener)
    }

    fun setRightIcon(@DrawableRes resId: Int) {
        val drawable = if (resId == 0) null else AppCompatResources.getDrawable(context, resId)
        setRightIcon(drawable)
    }

    fun setRightIcon(drawable: Drawable?) {
        viewBinding.ivRight.setImageDrawable(drawable)
        viewBinding.ivRight.isGone = drawable == null
    }

    fun setRightClickListener(listener: OnClickListener) {
        viewBinding.ivRight.setOnClickListener(listener)
    }

}