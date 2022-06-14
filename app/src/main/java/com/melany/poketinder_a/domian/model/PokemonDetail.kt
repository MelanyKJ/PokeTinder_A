package com.melany.poketinder_a.domian.model

data class PokemonDetail(
    val id: Int,
    val base_experience: Int,
    val height: Int,
    val weight: Int,
    val stats: List<Stats>,
    val types: List<Types>,
    val abilities: List<Abilities>
) {


}