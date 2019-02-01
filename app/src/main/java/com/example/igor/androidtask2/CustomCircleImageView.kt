package com.example.igor.androidtask2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import de.hdodenhof.circleimageview.CircleImageView

class CustomCircleImageView : CircleImageView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        var paint = Paint()
        paint.color = context.resources.getColor(R.color.black_alpha)
        paint.style = Paint.Style.FILL
        var radius = width/2f

        val oval = RectF()
        oval.set(width/2 - radius,
                height/2 - radius,
                width/2 + radius,
                height/2 + radius)
        canvas?.drawArc(oval, 22.5f, 135f, false, paint)
    }

}