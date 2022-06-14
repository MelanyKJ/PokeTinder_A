package com.melany.poketinder_a.domian.usecase

import com.melany.poketinder_a.data.PokemonRepository
import com.melany.poketinder_a.data.database.entities.toDatabase
import com.melany.poketinder_a.domian.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository){

    suspend operator fun invoke(myPokemon: MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
}
}
