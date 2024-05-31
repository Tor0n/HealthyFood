package com.example.healthyfood

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthyfood.ui.screens.HomeScreen
import com.example.healthyfood.ui.screens.SearchScreen
import com.example.healthyfood.ui.screens.ShoppingListScreen

@Composable
fun HealthyFoodApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeScreen(
                onSearchClick = { navController.navigate("ShoppingList") },
                onShoppingListClick = { navController.navigate("ShoppingList") }
            )
        }
        composable("Search") {
            SearchScreen(
                onHomeClick = { navController.navigate("Home")},
                onShoppingListClick = { navController.navigate("ShoppingList") }
            )
        }
        composable("ShoppingList") {
            ShoppingListScreen(
                onHomeClick = { navController.navigate("Home") },
                onSearchClick = { navController.navigate("Search") }
            )
        }
    }
}