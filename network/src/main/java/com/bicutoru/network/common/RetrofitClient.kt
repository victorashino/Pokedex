package com.bicutoru.network.common

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL: String = "https://pokeapi.co/api/v2/"

object RetrofitClient {

    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()

    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}