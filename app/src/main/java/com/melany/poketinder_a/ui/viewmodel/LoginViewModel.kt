package com.melany.poketinder_a.ui.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melany.poketinder_a.data.model.User
import com.melany.poketinder_a.util.SharedPreferenceUtil

class LoginViewModel(private val context: Context): ViewModel() {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    val emptyEmailError = MutableLiveData<Boolean>()
    val emptyPasswordError = MutableLiveData<Boolean>()
    val fieldAuthenticationError = MutableLiveData<Boolean>()
    val goSuccesActivity = MutableLiveData<Boolean>()

    fun onCreate() {
        sharedPreferenceUtil = SharedPreferenceUtil().also {
           it.setSharedPreference(context)
        }
}
    fun validateInputs( email: String, password:String){
        //validateInput()
        if(email.isEmpty()){
            emptyEmailError.postValue(true)
        }else if(password.isEmpty()){
            emptyPasswordError.postValue(true)
        }else {
            val user: User? = sharedPreferenceUtil.getUser()

            if (user?.email.equals(email) && user?.password.equals(password)) {
                goSuccesActivity.postValue(true)
            } else {
                fieldAuthenticationError.postValue(true)
            }
        }
    }
}