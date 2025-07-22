package com.example.swipecards.newView

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import com.example.swipecards.R

class GradientTextView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(
    context,
    attributeSet,
    defStyle) {

    private var startColor: Int = R.styleable.GradientTextView_startColor
    private var endColor: Int = R.styleable.GradientTextView_endColor

    init {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.GradientTextView,
            0,
            0
        ).apply {
            try {
                startColor = getColor(R.styleable.GradientTextView_startColor, startColor )
                endColor = getColor(R.styleable.GradientTextView_endColor, endColor )
            } finally {
                recycle()
            }
        }


    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        if (changed) {
            setupGradient()
        }

    }

    private fun setupGradient() {
        paint.shader = LinearGradient(
            0f,
            0f,
            width.toFloat(),
            0f,
            intArrayOf(startColor,endColor),
            null,
            Shader.TileMode.CLAMP
        )
    }
}



