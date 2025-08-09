package com.lana.multilangbackgroundapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lana.multilangbackgroundapp.ui.screens.MainScreen
import com.lana.multilangbackgroundapp.ui.screens.WelcomeScreen

// Rutas tipadas
sealed class Route(val path: String) {
    data object Home : Route("home")
    data object Welcome : Route("welcome")
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Home.path
    ) {
        composable(Route.Home.path) {
            MainScreen(
                onEnterClick = { navController.navigate(Route.Welcome.path) }
            )
        }
        composable(Route.Welcome.path) {
            WelcomeScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
