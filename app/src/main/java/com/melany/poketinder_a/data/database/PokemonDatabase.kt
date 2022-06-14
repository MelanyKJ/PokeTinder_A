package com.melany.poketinder_a.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.melany.poketinder_a.data.database.dao.PokemonDao
import com.melany.poketinder_a.data.database.entities.MyPokemonEntity
//AGREGAR LA VERSION 2, SI SE MODIFICA ENTITIES
@Database(entities = [MyPokemonEntity:: class], version =1)
abstract class PokemonDatabase: RoomDatabase(){
    abstract fun getPokemonDao(): PokemonDao
}