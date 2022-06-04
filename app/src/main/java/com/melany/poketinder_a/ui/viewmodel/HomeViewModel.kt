package com.melany.poketinder_a.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melany.poketinder_a.domian.model.Pokemon
import com.melany.poketinder_a.domian.usecase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
): ViewModel() {
    val pokemonList = MutableLiveData<List<Pokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result=getPokemonsUseCase()
            pokemonList.postValue(result)
            isLoading.postValue(false)
        }
    }
}
