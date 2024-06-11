package com.example.healthyfood.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthyfood.viewmodels.AddRecipeViewModel

@Composable
fun AddRecipeScreen(
    addRecipeViewModel: AddRecipeViewModel = viewModel(),
    //onAddClick: () -> Unit,
    onCancelClick: () -> Unit
) {
    //val addRecipeViewModel: AddRecipeViewModel = viewModel()
    //val recipeRepository: RecipeRepository by lazy { RecipeRepository(DB.appDatabase.recipeDao()) }
    //val addRecipeViewModel: AddRecipeViewModel by lazy { AddRecipeViewModel(recipeRepository = recipeRepository) }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    TextButton(onClick = { addRecipeViewModel.addRecipe() }) {
                        Text(text = "Add")
                    }
                    TextButton(onClick = { onCancelClick() }) {
                        Text(text = "Cancel")
                    }
                }
            )
        }
    ) {innerPadding ->
        AddRecipeCard(
            modifier = Modifier.padding(innerPadding),
            viewModel = addRecipeViewModel
        )
    }
}
@Composable
fun AddRecipeCard(modifier: Modifier, viewModel: AddRecipeViewModel) {
    /*var label by remember { mutableStateOf("label") }
    var ingredients by remember { mutableStateOf("ingredients") }
    var calories by remember { mutableStateOf("calories") }*/
    Column(modifier = modifier) {
        OutlinedTextField(value = viewModel.label, onValueChange = {
            viewModel.label = it
        })
        /*OutlinedTextField(value = viewModel.ingredients, onValueChange = {
            //viewModel.ingredients[1] = it
            viewModel.ingredients[1] = "123"
        })*/
        CommonTextField(
            title = "Calories", placeholder = "Calories",
            value = viewModel.calories,
            onValueChange = { viewModel.calories = format(it) }
        )
    }
}

@Composable
fun CommonTextField(
    title: String,
    placeholder: String,
    value: Double,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value.toString(),
        onValueChange = onValueChange,
        label = {
            Text(text = title)
        },
        placeholder = {
            Text(text = placeholder)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
}
private fun format(value: String): Double {
    return value.toDouble()
}