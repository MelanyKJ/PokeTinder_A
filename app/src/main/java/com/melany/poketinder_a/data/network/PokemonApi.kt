package com.melany.poketinder_a.data.network

import com.melany.poketinder_a.data.model.PokemonListModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET("?limit=20")
    suspend fun  getPokemons(): Response<PokemonListModel>
}