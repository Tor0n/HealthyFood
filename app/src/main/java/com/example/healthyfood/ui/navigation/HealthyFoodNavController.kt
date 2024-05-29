package com.example.healthyfood.ui.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun appNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "Home") {
        composable("Home") {

        }
        //composable("ShoppingList") { ShoppingList(onNavigateToHome = { navController.navigate("Home") }) }
    }
}