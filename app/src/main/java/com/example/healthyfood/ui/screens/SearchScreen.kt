package com.example.healthyfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthyfood.R
import com.example.healthyfood.viewmodels.SearchUiState
import com.example.healthyfood.viewmodels.SearchViewModel

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
                        Icon(Icons.Filled.Home, contentDescription = "Localized description")
                    }
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { onShoppingListClick() }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Localized description")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        }
    ){innerPadding ->
        when (searchUiState) {
            is SearchUiState.Loading -> LoadingScreen( modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding))
            is SearchUiState.Success -> ResultScreen(
                recipes = searchUiState.recipes, modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
            )
            is SearchUiState.Error -> ErrorScreen( modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding))
        }

    }
}
@Composable
fun ResultScreen(recipes: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = recipes)
    }
}
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
        Text(text = "Loading ...")
    }
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
        Text(text = "Error", modifier = Modifier.padding(16.dp))
    }
}