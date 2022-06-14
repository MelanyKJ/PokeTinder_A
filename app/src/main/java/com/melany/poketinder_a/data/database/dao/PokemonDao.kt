package com.melany.poketinder_a.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.melany.poketinder_a.data.database.entities.MyPokemonEntity
import androidx.room.Query


@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pokemon: MyPokemonEntity)

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemons(): List<MyPokemonEntity>
}