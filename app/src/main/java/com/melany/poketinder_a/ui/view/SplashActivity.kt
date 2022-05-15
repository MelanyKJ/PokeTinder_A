package com.melany.poketinder_a.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.melany.poketinder_a.databinding.ActivitySplashBinding
import com.melany.poketinder_a.ui.view.BaseActivity
import com.melany.poketinder_a.ui.view.LoginActivity
import com.melany.poketinder_a.util.SharedPreferenceUtil

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate){

    private lateinit var sharedPreferenceUtil:SharedPreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
        //SE PROGRAMA EL TIEMPO DE DURACIÓN DEL SPLASH ANTES DE PASAR AL MAIN ACTIVITY
        Handler(Looper.getMainLooper()).postDelayed(
            {
                //Evaluar si mostrar o no
                val isIntroAvailable = sharedPreferenceUtil.getIntroShow()
                if (!isIntroAvailable) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                finish()
            },
            3000
        )
    }
}

