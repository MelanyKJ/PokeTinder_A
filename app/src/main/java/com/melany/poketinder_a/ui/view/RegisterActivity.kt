package com.melany.poketinder_a.ui.view
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.melany.poketinder_a.activity.MainActivity
import com.melany.poketinder_a.databinding.ActivityRegisterBinding
import com.melany.poketinder_a.ui.viewmodel.RegisterViewModel

class RegisterActivity: BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {
    private lateinit var RegisterViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        RegisterViewModel = RegisterViewModel(this)
        RegisterViewModel.onCreate()

        RegisterViewModel.emptyUserError.observe(this){
            Toast.makeText(this,"Completar Nombre de Usuario",Toast.LENGTH_SHORT).show()
        }
        RegisterViewModel.emptyEmailError.observe(this){
            Toast.makeText(this,"Completar Email",Toast.LENGTH_SHORT).show()
        }
        RegisterViewModel.emptyPasswordError.observe(this){
            Toast.makeText(this,"Completar Contraseña",Toast.LENGTH_SHORT).show()
        }
        RegisterViewModel.emptyPasswordError.observe(this){
            Toast.makeText(this,"Completar Contraseña",Toast.LENGTH_SHORT).show()
        }
        RegisterViewModel.FieldsDoNotMatch.observe(this){
            Toast.makeText(this,"No coincide las contraseñas",Toast.LENGTH_SHORT).show()
        }
        RegisterViewModel.goSuccesActivity.observe(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        RegisterViewModel.loadLoginActivity.observe(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        }

        fun loginUser(view:View){
            RegisterViewModel.continueLogin()

        }
        //VALIDACION DE LOS INPUTS
        fun registerUser(view:View){
            RegisterViewModel.validateInputs(
                binding.edtUserName.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString(),
                binding.edtPassword2.text.toString())
    }
}




