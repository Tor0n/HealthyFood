package com.example.healthyfood

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthyfood.ui.theme.HealthyFoodTheme

@Composable
fun HealthyFoodApp() {
    HealthyFoodTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "Home") {
            composable("Home") {

            }
            composable("ShoppingList") { ShoppingList(onNavigateToHome = { navController.navigate("Home") }) }
        }
    }
}
@Composable
fun ShoppingList(onNavigateToHome: () -> Unit) {
    Text("Shopping List")
    Button(onClick = { onNavigateToHome() }) {
        Text("Go to Profile")
    }
}