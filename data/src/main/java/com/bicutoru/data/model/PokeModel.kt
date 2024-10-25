package com.bicutoru.data.model

data class PokeModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<Ability>,
    val types: List<TypeDetail>
) {
    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/$id.gif"
}

data class TypeDetail(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
    val url: String
)

data class Ability(
    val ability: AbilityDetail
)

data class AbilityDetail(
    val name: String,
    val url: String
)