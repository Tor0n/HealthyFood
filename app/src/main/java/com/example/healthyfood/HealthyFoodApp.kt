package com.example.healthyfood

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthyfood.ui.screens.AddRecipeSreen
import com.example.healthyfood.ui.screens.HomeScreen
import com.example.healthyfood.ui.screens.SearchScreen
import com.example.healthyfood.ui.screens.ShoppingListScreen
import com.example.healthyfood.viewmodels.SearchViewModel

@Composable
fun HealthyFoodApp() {
    //val homeViewModel: HomeViewModel = viewModel()
    val searchViewModel: SearchViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeScreen(
                onSearchClick = { navController.navigate("Search") },
                onShoppingListClick = { navController.navigate("ShoppingList") },
                onAddClick = { navController.navigate("AddRecipe") }
            )
        }
        composable("Search") {
            SearchScreen(
                onHomeClick = { navController.navigate("Home")},
                onShoppingListClick = { navController.navigate("ShoppingList") },
                searchUiState = searchViewModel.searchUiState
            )
        }
        composable("ShoppingList") {
            ShoppingListScreen(
                onHomeClick = { navController.navigate("Home") },
                onSearchClick = { navController.navigate("Search") }
            )
        }
        composable("AddRecipe") {
            AddRecipeSreen(
                onAddClick = { /*TODO*/ },
                onCancelClick = { navController.navigate("Home") }
            )
        }
    }
}