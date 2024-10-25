package com.bicutoru.data.response

import com.bicutoru.data.model.PokeModel
import com.google.gson.annotations.SerializedName

data class PokeListResponse(
    @SerializedName("count")
    val count: Int,

    @SerializedName("next")
    val next: String?,

    @SerializedName("previous")
    val previous: String?,

    @SerializedName("results")
    val pokemons: List<PokeResponse>
)

data class PokeResponse(

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)