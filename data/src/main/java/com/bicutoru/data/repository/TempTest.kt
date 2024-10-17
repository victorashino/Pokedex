package com.bicutoru.data.repository

import com.bicutoru.data.common.RetrofitClient
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val repository = PokeRepository()

    val result = repository.getPokemons()

    if (result.isSuccess) {
        val pokemons = result.getOrNull()
        println("Pokémons recebidos: $pokemons")
    } else {
        println("Erro ao buscar Pokémons: ${result.exceptionOrNull()}")
    }
}