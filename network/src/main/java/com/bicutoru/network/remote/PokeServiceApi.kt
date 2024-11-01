package com.bicutoru.network.remote

import com.bicutoru.network.model.PokeModel
import com.bicutoru.network.response.PokeListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeServiceApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokeListResponse>

    @GET
    suspend fun getDetails(
        @Url url: String
    ): Response<PokeModel>

}