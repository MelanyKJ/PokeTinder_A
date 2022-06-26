package com.melany.poketinder_a.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.melany.poketinder_a.R

class FirebaseRemoteConfigRepository {
    val instance = FirebaseRemoteConfig.getInstance()

    val getUrlPokemonLiveData: MutableLiveData<String> = MutableLiveData()
    val isUnderMaintenanceLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun init(){
        instance.setDefaultsAsync(R.xml.remote_config_defaults)
        instance.fetchAndActivate().addOnCompleteListener{task ->
            if(task.isSuccessful){
                getUrlPokemonLiveData.value = getUrlPokemonLive()
                isUnderMaintenanceLiveData.value = getUnderMaintenance()
            }
        }
    }

    private fun getUrlPokemonLive(): String {
        return instance["url_pokemon_live"].asString()
    }

    private fun getUnderMaintenance():Boolean{
        return  instance["is_under_maintenance"].asBoolean()
    }
}





















