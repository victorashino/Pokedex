package com.bicutoru.onboarding

sealed class Screen(val route: String) {
    data object PokeList: Screen("poke_list")
}