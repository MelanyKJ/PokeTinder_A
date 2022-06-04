package com.melany.poketinder_a.data.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
)
