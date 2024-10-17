package com.bicutoru.data.repository

import com.bicutoru.data.model.Ability
import com.bicutoru.data.model.AbilityDetail
import com.bicutoru.data.model.PokeModel
import com.bicutoru.data.model.Type
import kotlinx.coroutines.runBlocking

// TEST GET POKEMONS
/*fun main() = runBlocking {
    val repository = PokeRepository()

    val result = repository.getPokemons()

    if (result.isSuccess) {
        val pokemons = result.getOrNull()
        println("Pokémons recebidos: $pokemons")
    } else {
        println("Erro ao buscar Pokémons: ${result.exceptionOrNull()}")
    }
}*/

// TEST GET DETAIL
fun main() = runBlocking {
    val repository = PokeRepository()

    val pokemonUrl = "https://pokeapi.co/api/v2/pokemon/1/"

    val result = repository.getPokemonDetails(pokemonUrl)

    if (result.isSuccess) {
        val pokemonDetails = result.getOrNull()
        println("Detalhes do Pokémon recebidos: $pokemonDetails")
    } else {
        println("Erro ao buscar detalhes do Pokémon: ${result.exceptionOrNull()}")
    }
}

 // TEST GET GIF
/*
fun main() = runBlocking {
    val bulbasaur = PokeModel(
        id = 1,
        name = "bulbasaur",
        height = 7,
        weight = 69,
        abilities = listOf(Ability(AbilityDetail("overgrow", ""))),
        types = listOf(Type("grass"), Type("poison"))
    )

    println(bulbasaur.imageUrl)
}*/
