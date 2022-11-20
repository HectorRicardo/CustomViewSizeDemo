package edu.utap.hectormendez.customviewsizedemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CustomView : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )
    constructor(
        context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private val paint = Paint().apply {
        strokeWidth = 50f
        color = Color.RED
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Log the parameters to debug
        val widthSpecString = MeasureSpec.toString(widthMeasureSpec)
        val heightSpecString = MeasureSpec.toString(heightMeasureSpec)
        Log.d("------", "width=$widthSpecString, height=$heightSpecString")

        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        val contentWidth = width - paddingStart - paddingEnd
        val contentHeight = height - paddingTop - paddingBottom

        val startX = paddingStart.toFloat()
        val endX = startX + contentWidth
        val startY = paddingTop.toFloat()
        val endY = startY + contentHeight

        canvas.drawLine(startX, startY, endX, startY, paint)
        canvas.drawLine(endX, startY, endX, endY, paint)
        canvas.drawLine(endX, endY, startX, endY, paint)
        canvas.drawLine(startX, endY, startX, startY, paint)
    }
}