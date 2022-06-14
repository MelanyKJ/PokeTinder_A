package com.melany.poketinder_a.domian.usecase

import com.melany.poketinder_a.data.PokemonRepository
import com.melany.poketinder_a.domian.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository){
    suspend operator fun invoke(): List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
}
}
