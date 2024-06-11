package com.example.healthyfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfood.R
import com.example.healthyfood.data.database.RecipeQ
import com.example.healthyfood.testDataHome

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
        RecipeList(modifier = Modifier.padding(innerPadding), recipes = testDataHome.RecipesList)
    }
}
@Preview
@Composable
fun previewHomeScreen() {
    RecipeList(
        modifier = Modifier.padding(4.dp),
        recipes = testDataHome.RecipesList
    )
}
@Composable
fun RecipeCard(recipe: RecipeQ) {
    Row {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = recipe.label
            )
            Row {
                Text(text = recipe.ingredients[1])
                Text(text = recipe.ingredients[2])
                Text(text = recipe.ingredients[3])
                if(recipe.ingredients[4].isNotEmpty()){

                }
            }

        }
    }
}
@Composable
fun RecipeList(modifier: Modifier, recipes: List<RecipeQ>) {
    LazyColumn(modifier = modifier) {
        items(recipes) {recipe ->
            RecipeCard(recipe)
        }
    }
}