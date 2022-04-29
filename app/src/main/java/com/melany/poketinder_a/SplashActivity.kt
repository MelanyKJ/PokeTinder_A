package com.melany.poketinder_a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.AlarmClock
import com.melany.poketinder_a.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    // activitySplashBinding
    private lateinit var activitySplashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activitySplashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = activitySplashBinding.root
        setContentView(view)

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "message")
        }
        //HEANDLER
        Handler(Looper.getMainLooper()).postDelayed({ startActivity(intent); finish() },3000)
    }
}