package com.example.healthyfood.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddRecipeSreen(
    onAddClick: () -> Unit,
    onCancelClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    TextButton(onClick = { onCancelClick() }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { onAddClick() }) {
                        Text(text = "Add")
                    }
                }
            )
        }
    ) {innerPadding ->
        AddRecipeCard(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun AddRecipeCard(modifier: Modifier) {
    Column(modifier = Modifier.padding(all = 4.dp)) {
        Row {
            Text(text = "Label")
        }
        Row {
            Text(text = "Ingredients")
        }
    }
    
}