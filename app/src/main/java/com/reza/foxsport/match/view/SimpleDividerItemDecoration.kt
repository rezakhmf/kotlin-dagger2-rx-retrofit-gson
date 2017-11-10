package com.reza.foxsport.match.view

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.graphics.drawable.Drawable
import com.reza.foxsport.R
import android.opengl.ETC1.getWidth




/**
 * Created by reza on 8/11/17.
 */
class SimpleDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var mDivider: Drawable? = null

    init {
        mDivider = context.getResources().getDrawable(R.drawable.line_divider)
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
       // val mDivider = context.resources?.getDrawable(R.drawable.line_divider)
        val left = parent?.getPaddingLeft()
        val right = parent?.width?.minus(parent?.paddingRight)

        val childCount = parent?.getChildCount()


        if(childCount!!> 0) {
            for (i in 0..childCount!!) {
                val child = parent.getChildAt(i)

                val params = child.layoutParams as RecyclerView.LayoutParams

                val top = child.bottom + params.bottomMargin
                val bottom = top + (mDivider?.intrinsicHeight ?: 0)

                mDivider?.setBounds(left!!, top!!, right!!, bottom)
                mDivider?.draw(c)
            }
        }

    }
}


