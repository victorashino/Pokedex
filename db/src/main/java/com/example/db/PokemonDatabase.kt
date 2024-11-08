package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PokemonEntity::class], version = 1)
@TypeConverters(PokeTypeConverters::class)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun getPokeDao(): PokeDao
}