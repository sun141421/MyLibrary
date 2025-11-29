package com.speedandroid.speedcodelibrary.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox

/**
 * 扩展CheckBox
 * 添加一个方法setCheckedSkipCall 切换选中时不调用OnCheckedChangeListener
 * 应用场景有 当切换选中后调用OnCheckedChangeListener进行操作,发现不满足,需要退回原来的状态,
 * 如果用普通方法,会再次调用OnCheckedChangeListener, 这会造成重复调用,甚至循环, 这时调用这个方法,仅仅重置原来的选中状态即可
 * */
class SkipCallCheckBox @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatCheckBox(context, attrs) {
    private var myListener: OnCheckedChangeListener? = null

    override fun setOnCheckedChangeListener(listener: OnCheckedChangeListener?) {
        myListener = listener
        super.setOnCheckedChangeListener(listener)
    }

    /**
     * 切换选中时不调用OnCheckedChangeListener
     * */
    fun setCheckedSkipCall(checked: Boolean) {
        super.setOnCheckedChangeListener(null)
        super.setChecked(checked)
        super.setOnCheckedChangeListener(myListener)
    }

}
