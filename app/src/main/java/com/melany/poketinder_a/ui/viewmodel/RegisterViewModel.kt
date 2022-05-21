package com.melany.poketinder_a.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.melany.poketinder_a.data.model.User
import com.melany.poketinder_a.util.SharedPreferenceUtil


class RegisterViewModel(private val context: Context) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyUserError = MutableLiveData<Boolean>()
    val emptyEmailError = MutableLiveData<Boolean>()
    val emptyPasswordError = MutableLiveData<Boolean>()
    val emptyPassword2Error = MutableLiveData<Boolean>()
    val FieldsDoNotMatch = MutableLiveData<Boolean>()
    val loadLoginActivity = MutableLiveData<Boolean>()

    val goSuccesActivity = MutableLiveData<Boolean>()


    fun onCreate(){
        sharedPreferenceUtil= SharedPreferenceUtil().also{
            it.setSharedPreference(context)
        }
    }

    fun validateInputs(username: String, email:String, password: String, password2: String){

        //validateInput()
        if(username.isEmpty()){
            emptyUserError.postValue(true)
        }else if(email.isEmpty()){
            emptyEmailError.postValue(true)
        }else if(password.isEmpty()){
            emptyPasswordError.postValue(true)
        }else if(password2.isEmpty()){
            emptyPassword2Error.postValue(true)
        }else if(password != password2){
            FieldsDoNotMatch.postValue(true)
        }else{
            //Se usó de contraseña 123
            val user = User(
                "1",
                username,
                email,
                password)
            sharedPreferenceUtil.saveFacebookUser(user)
            goSuccesActivity.postValue(true)
        }
    }


    fun sendToLogin(){
        loadLoginActivity.postValue(true)
    }
}