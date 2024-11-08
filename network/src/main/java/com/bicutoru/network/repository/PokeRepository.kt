package com.bicutoru.network.repository

import android.util.Log
import com.bicutoru.network.model.PokeModel
import com.bicutoru.network.remote.PokeServiceApi
import com.bicutoru.network.response.PokeListResponse
import java.io.IOException
import javax.inject.Inject

class PokeRepository @Inject constructor(
    private val service: PokeServiceApi
) {

    suspend fun getPokemons(limit: Int = 920, offset: Int = 0): Result<PokeListResponse> {
        return try {
            val response = service.getPokemonList(limit, offset)
            Log.d("PokeRepository", "Response: $response")

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    println("Pokémons recebidos: ${body.pokemons}")
                    Result.success(body)
                } else {
                    println("Corpo da resposta está nulo")
                    Result.failure(IOException("Body is null"))
                }
            } else {
                println("Erro de rede: ${response.code()} ${response.message()}")
                Result.failure(IOException("Network error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            println("Erro de comunicação: ${e.message}")
            Result.failure(IOException("Communication error: ${e.message}", e))
        }
    }


    suspend fun getPokemonDetails(url: String): Result<PokeModel> {
        return try {
            val response = service.getDetails(url)

            if (response.isSuccessful) {
                val body = response.body()
                Log.d("PokeRepository getPokemonDetails", "response.body: $body")
                if (body != null) {
                    Result.success(body)
                } else {
                    Result.failure(IOException("Body is null"))
                }
            } else {
                Result.failure(IOException("Network error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.failure(IOException("Comunication error: ${e.message}", e))
        }
    }
}