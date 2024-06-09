package com.example.healthyfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.healthyfood.R
import com.example.healthyfood.data.edamamRecipe
import com.example.healthyfood.viewmodels.SearchUiState

@Composable
fun SearchScreen(
    onHomeClick: () -> Unit,
    onShoppingListClick: () -> Unit,
    searchUiState: SearchUiState
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { onHomeClick() }) {
                        Icon(Icons.Filled.Home, contentDescription = "")
                    }
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                    IconButton(onClick = { onShoppingListClick() }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "")
                    }
                },
                /*floatingActionButton = {
                    FloatingActionButton(
                        onClick = {  },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Search, "Localized description")
                    }
                }*/
            )
        }
    ){innerPadding ->
        when (searchUiState) {
            is SearchUiState.Loading -> LoadingScreen( modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            )
            is SearchUiState.Success -> ResultScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                edamamRecipes = searchUiState.edamamRecipes
            )
            is SearchUiState.Error -> ErrorScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }

    }
}
@Composable
fun ResultScreen(modifier: Modifier = Modifier, edamamRecipes: Array<edamamRecipe>) {
    LazyColumn(modifier = modifier) {
        /*items(recipeList) {recipe ->

        }*/
    }
}
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column {
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
            Text(text = "Loading ...")
        }
    }
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Column {
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
            Text(text = "*Error*", modifier = Modifier.padding(16.dp))
        }
    }
}