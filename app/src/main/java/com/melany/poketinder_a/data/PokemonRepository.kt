package com.melany.poketinder_a.data

import com.melany.poketinder_a.data.database.dao.PokemonDao
import com.melany.poketinder_a.data.database.entities.MyPokemonEntity
import com.melany.poketinder_a.data.model.PokemonDetailModel
import com.melany.poketinder_a.data.model.PokemonListModel
import com.melany.poketinder_a.data.model.PokemonModel
import com.melany.poketinder_a.data.network.PokemonService
import com.melany.poketinder_a.domian.model.MyPokemon
import com.melany.poketinder_a.domian.model.Pokemon
import com.melany.poketinder_a.domian.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.result
        return response.map {it.toDomain()}
    }

    suspend fun getPokemonDetailFromApi(idPokemon:String): PokemonDetailModel {
        return pokemonService.getPokemonById(idPokemon)

    }

/*
    suspend fun getPokemonDetailFromApi(idPokemon:String): PokemonDetail {
        val response =pokemonService.getPokemonById(idPokemon)
        return response.ToDomain()
    }
*/
    suspend fun getMyPokemonsFromDatabase():List<MyPokemon> {
        val response: List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map{ it.toDomain()}
    }

    suspend fun insertMyPokemon(myPokemon: MyPokemonEntity) {
        pokemonDao.insert(myPokemon)
    }

    suspend fun deleteAllMyPokemon(){
        pokemonDao.deleteTable()
    }
}













