package com.melany.poketinder_a.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melany.poketinder_a.data.User
import com.melany.poketinder_a.util.SharedPreferenceUtil

class RegisterViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    //val emptyFieldError = MutableLiveData<Boolean>()
    //val fieldAuthenticationError = MutableLiveData<Boolean>()
    val goSuccesActivity = MutableLiveData<Boolean>()
    val emptyUserError = MutableLiveData<Boolean>()
    val emptyEmailError = MutableLiveData<Boolean>()
    val emptyPasswordError = MutableLiveData<Boolean>()
    val emptyPassword2Error = MutableLiveData<Boolean>()
    val loadLoginActivity = MutableLiveData<Boolean>()
    val FieldsDoNotMatch = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(context)
        }
    }

    fun validateInputs( name: String, email: String, password: String, password2: String){
        if(name.isEmpty()){
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
            val user = User("1", name, email, password)
            sharedPreferenceUtil.saveFacebookUser(user)
            goSuccesActivity.postValue(true)
        }
    }

    fun continueLogin(){
        loadLoginActivity.postValue(true)
}
}