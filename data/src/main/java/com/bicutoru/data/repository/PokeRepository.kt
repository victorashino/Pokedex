package com.bicutoru.data.repository

import com.bicutoru.data.common.RetrofitClient
import com.bicutoru.data.model.PokeModel
import com.bicutoru.data.remote.PokeServiceApi
import com.bicutoru.data.response.PokeResponse
import retrofit2.Response
import java.io.IOException

class PokeRepository {

    private val service = RetrofitClient.pokeServiceApi

    suspend fun getPokemons(limit: Int = 20, offset: Int = 0): Result<PokeResponse> {
        return try {
            val response = service.getPokemonList(limit, offset)

            if (response.isSuccessful) {
                val body = response.body()
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

    suspend fun getPokemonDetails(url: String): Result<PokeModel> {
        return try {
            val response = service.getDetails(url)

            if (response.isSuccessful) {
                val body = response.body()
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