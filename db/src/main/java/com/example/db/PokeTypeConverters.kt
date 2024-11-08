package com.example.db

import androidx.room.TypeConverters
import com.bicutoru.network.model.Ability
import com.bicutoru.network.model.Type
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PokeTypeConverters {

    @TypeConverters
    fun fromAbilitiesList(abilities: List<Ability>): String {
        return Gson().toJson(abilities)
    }

    @TypeConverters
    fun toAbilitiesList(abilitiesJson: String): List<Ability> {
        val type = object: TypeToken<List<Ability>>() {  }.type
        return Gson().fromJson(abilitiesJson, type)
    }

    @TypeConverters
    fun fromTypeList(types: List<Type>): String {
        return Gson().toJson(types)
    }

    @TypeConverters
    fun toTypeList(typesJson: String): List<Type> {
        val type = object: TypeToken<List<Type>>() {  }.type
        return Gson().fromJson(typesJson, type)
    }

}