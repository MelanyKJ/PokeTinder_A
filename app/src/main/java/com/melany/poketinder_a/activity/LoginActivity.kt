package com.melany.poketinder_a.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.melany.poketinder_a.data.User
import com.melany.poketinder_a.databinding.ActivityLoginBinding
import com.melany.poketinder_a.util.SharedPreferenceUtil

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }
    fun validateInput(){
        if(binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            //AGREGAR TOAST
        }
    }
    fun startLogin(view: View){
        //validateInput()
        val user: User? =sharedPreferenceUtil.getUser()

        if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Error de usuario",Toast.LENGTH_SHORT).show()
        }
    }
}



















