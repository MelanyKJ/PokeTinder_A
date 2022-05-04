package com.melany.poketinder_a.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.melany.poketinder_a.data.User
import com.melany.poketinder_a.databinding.ActivityRegisterBinding
import com.melany.poketinder_a.util.SharedPreferenceUtil

class RegisterActivity: BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }

    fun registerUser(view: View){
        val user = User(
            "1",
            name= binding.edtUserName.text.toString(),
            email = binding.edtEmail.text.toString(),
            password = binding.edtPassword.text.toString())
        sharedPreferenceUtil.saveFacebookUser(user)
        val intent = Intent(application, LoginActivity::class.java)
        intent.putExtra("user",user)
        startActivity(intent)
    }
    fun loginUser(view:View){
        val intent = Intent(applicationContext, LoginActivity:: class.java)
        startActivity(intent)
    }
}