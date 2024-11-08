package com.example.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemons(pokemons: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon_table")
    suspend fun getAllPokemons(): List<PokemonEntity>

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteAllPokemons()

}