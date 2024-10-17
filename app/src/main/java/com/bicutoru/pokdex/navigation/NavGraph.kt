package com.bicutoru.pokdex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bicutoru.onboarding.OnBoardingScreen

sealed class Screen(val route: String) {
    data object OnBoarding: Screen("on_boarding")
}

@Composable
fun NavGraph(startDestination: String = Screen.OnBoarding.route) {

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.OnBoarding.route) { OnBoardingScreen(navController) }
    }
}