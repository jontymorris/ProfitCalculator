package me.morris.grossprofitcalculator

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // add touch listener to all button layouts
        for (i in 0 until buttonGrid.childCount) {
            buttonGrid.getChildAt(i).setOnTouchListener {view, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> view.setBackgroundColor(Color.parseColor("#e3e3e3"))
                    MotionEvent.ACTION_UP -> view.setBackgroundColor(Color.parseColor("#000000FF"))
                }

                true
            }
        }
    }
}
