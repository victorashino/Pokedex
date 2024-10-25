package com.bicutoru.poke_list

sealed class Screen(val route: String) {
    data object PokeList: Screen("poke_list")
}