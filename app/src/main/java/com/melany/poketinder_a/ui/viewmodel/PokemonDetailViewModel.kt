package com.melany.poketinder_a.ui.viewmodel
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melany.poketinder_a.data.model.PokemonDetailModel
import com.melany.poketinder_a.databinding.ActivityPokemonDetailBinding
import com.melany.poketinder_a.domian.usecase.GetMyPokemonDetailUseCase
import com.melany.poketinder_a.ui.view.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getMyPokemonDetailUseCase: GetMyPokemonDetailUseCase
): ViewModel(){
    val pokemonDetailModel = MutableLiveData<PokemonDetailModel>()
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(idPokemon:String){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMyPokemonDetailUseCase.invoke(idPokemon)
            pokemonDetailModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}

