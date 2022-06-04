package com.melany.poketinder_a.data

import com.melany.poketinder_a.data.model.PokemonListModel
import com.melany.poketinder_a.data.model.PokemonModel
import com.melany.poketinder_a.data.network.PokemonService
import com.melany.poketinder_a.domian.model.Pokemon
import com.melany.poketinder_a.domian.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }
}
