package com.melany.poketinder_a.domian.usecase

import com.melany.poketinder_a.data.PokemonRepository
import com.melany.poketinder_a.domian.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository:PokemonRepository){
    suspend operator fun invoke():List<Pokemon>{
        return repository.getAllPokemonFromApi()
    }
}
