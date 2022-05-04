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
            Toast.makeText(this,"Completar los campos",Toast.LENGTH_SHORT).show()
        }else if(binding.edtEmail.text.isEmpty() &&  binding.edtPassword.text.isNotEmpty()){
            Toast.makeText(this,"Completar Email",Toast.LENGTH_SHORT).show()
        }else if(binding.edtEmail.text.isNotEmpty() && binding.edtPassword.text.isEmpty()){
            Toast.makeText(this,"Completar Contraseña",Toast.LENGTH_SHORT).show()
        }
    }
    fun startLogin(view: View){
        //validateInput()
        val user: User? =sharedPreferenceUtil.getUser()

        if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }else if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password !=(binding.edtPassword.text.toString())) {
            Toast.makeText(this,"Contraseña Incorrecta",Toast.LENGTH_SHORT).show()
        }else if(user?.email !=(binding.edtEmail.text.toString()) && user?.password !=(binding.edtPassword.text.toString())
            && binding.edtEmail.text.isNotEmpty() && binding.edtPassword.text.isNotEmpty()) {
            Toast.makeText(this,"Campos Incorrectos",Toast.LENGTH_SHORT).show()
        }
        else{
            validateInput()
        }
        fun registroUsuario(view:View){
            val firstIntent = Intent(this, RegisterActivity::class.java)
            startActivity(firstIntent)
        }
        }
    }




















