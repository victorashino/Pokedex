package com.bicutoru.data.remote

import com.bicutoru.data.model.PokeModel
import com.bicutoru.data.response.PokeListResponse
import com.bicutoru.data.response.PokeResponse
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