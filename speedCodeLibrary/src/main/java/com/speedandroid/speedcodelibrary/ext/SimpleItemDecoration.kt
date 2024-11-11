package com.speedandroid.speedcodelibrary.ext

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.sbds.library.gm.ext.dp

/**简单的ItemDecoration*/
class SimpleItemDecoration(
    private val leftInDp: Int,
    private val topInDp: Int,
    private val rightInDp: Int,
    private val bottomInDp: Int
) : ItemDecoration() {

    constructor(verticalInDp: Int, horizontalInDp: Int) : this(horizontalInDp, verticalInDp, horizontalInDp, verticalInDp)

    constructor(allInDp: Int) : this(allInDp, allInDp, allInDp, allInDp)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(leftInDp.dp, topInDp.dp, rightInDp.dp, bottomInDp.dp)

    }
}