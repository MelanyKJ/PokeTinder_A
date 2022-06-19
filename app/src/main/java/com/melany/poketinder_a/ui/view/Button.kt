package com.melany.poketinder_a.ui.view

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import co.ankurg.expressview.ExpressView
import com.melany.poketinder_a.R

class Button : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DON'T LIKE
        val floatingActionButton = findViewById<ExpressView>(R.id.floatingActionButton)
        floatingActionButton.interpolator = AnticipateOvershootInterpolator()
        floatingActionButton.iconAnimationDuration = 300

        //LIKE
        val floatingActionButton3 = findViewById<ExpressView>(R.id.floatingActionButton3)
        floatingActionButton3.interpolator = AnticipateOvershootInterpolator()
        floatingActionButton3.iconAnimationDuration = 300

    }
}