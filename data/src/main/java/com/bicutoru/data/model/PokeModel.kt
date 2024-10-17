package com.bicutoru.data.model

import com.google.gson.annotations.SerializedName

data class PokeModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class AbilitySlot(
    val ability: AbilityInfo
)

data class AbilityInfo(
    val name: String,
    val url: String
)

data class TypeSlot(
    val slot: Int,
    val type: TypeInfo
)

data class TypeInfo(
    val name: String,
    val url: String
)