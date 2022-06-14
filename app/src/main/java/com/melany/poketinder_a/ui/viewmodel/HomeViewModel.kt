package com.melany.poketinder_a.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melany.poketinder_a.domian.model.MyPokemon
import com.melany.poketinder_a.domian.model.Pokemon
import com.melany.poketinder_a.domian.usecase.GetPokemonsUseCase
import com.melany.poketinder_a.domian.usecase.SaveMyPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val saveMyPokemonUseCase: SaveMyPokemonUseCase
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

    fun savePokemonUseCase(myPokemon:MyPokemon){
        viewModelScope.launch {
            isLoading.postValue(true)
            saveMyPokemonUseCase.invoke(myPokemon)
            isLoading.postValue(false)
        }
    }
}
