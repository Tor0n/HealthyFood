package com.example.healthyfood.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfood.TestData

@Composable
fun HomeScreen(
    onSearchClick: () -> Unit,
    onShoppingListClick: () -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "")
                    }
                    IconButton(onClick = { onSearchClick() }) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                    IconButton(onClick = { onShoppingListClick() }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { onAddClick() },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "")
                    }
                }
            )
        }
    ) {innerPadding ->
        RecipeList(modifier = Modifier.padding(innerPadding), recipes = TestData.RecipesList)
    }
}
@Preview
@Composable
fun previewHomeScreen() {
    RecipeList(
        modifier = Modifier.padding(4.dp),
        recipes = TestData.RecipesList
    )
}
data class Recipe(val name: String, val calories: Double)
@Composable
fun RecipeCard(recipe: Recipe) {
    Row(modifier = Modifier.padding(all = 4.dp)) {
        Text(
            text = recipe.name + ", calories: " + recipe.calories
        )
    }
}
@Composable
fun RecipeList(modifier: Modifier, recipes: List<Recipe>) {
    LazyColumn(modifier = modifier) {
        items(recipes) {recipe ->
            RecipeCard(recipe)
        }
    }
}