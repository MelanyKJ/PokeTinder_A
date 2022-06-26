package com.melany.poketinder_a.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melany.poketinder_a.data.FirebaseRemoteConfigRepository


class InfoViewModel: ViewModel() {

    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init{
        firebaseRemoteConfigRepository.init()
    }

    fun getUrlPokemon(): MutableLiveData<String> {
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }
}
