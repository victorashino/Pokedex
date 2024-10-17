package com.bicutoru.data.remote

import com.bicutoru.data.response.PokeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeServiceApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<PokeResponse>

}