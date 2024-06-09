package com.example.healthyfood.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfood.data.database.Recipe
import com.example.healthyfood.data.database.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class AddRecipeViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    var label: String by mutableStateOf("")
    var ingredients: String by mutableStateOf("")
    var calories: Double by mutableStateOf(0.0)
    fun AddRecipe() {
        viewModelScope.launch {
            recipeRepository.insertRecipe(
                Recipe(label = label,
                    ingredients = ingredients,
                    calories = calories)
            )
        }
    }
}