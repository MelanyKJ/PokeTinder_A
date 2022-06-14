package com.melany.poketinder_a.domian.usecase

import com.melany.poketinder_a.data.PokemonRepository
import com.melany.poketinder_a.data.model.PokemonDetailModel
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(
    private val repository:PokemonRepository) {

    suspend operator fun invoke(id:String):PokemonDetailModel{
        return repository.getPokemonDetailFromApi(id)

    }
}
