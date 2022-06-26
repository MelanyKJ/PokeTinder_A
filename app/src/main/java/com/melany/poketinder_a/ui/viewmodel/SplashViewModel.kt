package com.melany.poketinder_a.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melany.poketinder_a.data.FirebaseRemoteConfigRepository

class SplashViewModel: ViewModel() {
    private var firesbaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init{
        firesbaseRemoteConfigRepository.init()
    }

    fun getIsUnderMaintenance(): MutableLiveData<Boolean> {
        return firesbaseRemoteConfigRepository.isUnderMaintenanceLiveData
    }

}