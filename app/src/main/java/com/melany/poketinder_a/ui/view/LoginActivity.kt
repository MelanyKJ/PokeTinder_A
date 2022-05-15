package com.melany.poketinder_a.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.melany.poketinder_a.activity.MainActivity
import com.melany.poketinder_a.databinding.ActivityLoginBinding
import com.melany.poketinder_a.ui.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = LoginViewModel(this)
        loginViewModel.onCreate()

        //ESCUCHAR LOS PARAMETROS DE VIEWMODEL
        loginViewModel.emptyFieldError.observe(this) {
            Toast.makeText(this,"Ingrese los datos de Usuario",Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldAuthenticationError.observe(this){
            Toast.makeText(this,"Error Usuario",Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSuccesActivity.observe(this){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }
    }

    fun startLogin(view: View){
        loginViewModel.validateInputs(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())

    }
}




















