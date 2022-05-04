package com.melany.poketinder_a.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    //ALERTDIALOG
    fun showDialog(view: android.view.View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Incorrecto")
        builder.setMessage("Vuelva a ingresar por favor...")
            .setPositiveButton("OK",
                DialogInterface.OnClickListener{dialog, id ->
                })
        // Create the AlertDialog object and return it
        //builder.create()
        builder.show()

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

    fun registerUser(view: View){
        val user = User(
            "1",
            name= binding.edtUserName.text.toString(),
            email = binding.edtEmail.text.toString(),
            password = binding.edtPassword.text.toString())
        sharedPreferenceUtil.saveFacebookUser(user)

        if(binding.edtUserName.text.isNotEmpty() && binding.edtPassword.text.isNotEmpty() &&
            binding.edtEmail.text.isNotEmpty() && binding.edtPassword2.text.isNotEmpty()){

            val intent = Intent(application, LoginActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }else if(binding.edtEmail.text.isNotEmpty() && binding.edtPassword.text.isNotEmpty() &&
            binding.edtUserName.text.isNotEmpty() && binding.edtPassword2.text.isNotEmpty() && binding.edtPassword.text.length>1
            && binding.edtPassword.text.length< 6){
            Toast.makeText(this,"La contraseña no debe ser menor de 6 digitos",Toast.LENGTH_SHORT).show()

        }else {
            validateInput()
        }


    }
    fun loginUser(view:View){
        val intent = Intent(applicationContext, LoginActivity:: class.java)
        startActivity(intent)
    }
}