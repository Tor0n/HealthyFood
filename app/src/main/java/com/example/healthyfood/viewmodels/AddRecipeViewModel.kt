package com.example.healthyfood.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfood.data.database.Recipe
import com.example.healthyfood.data.database.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    var label: String by mutableStateOf("")
    var ingredients: List<String> by mutableStateOf(listOf(""))
    var calories: Double by mutableStateOf(0.0)
    fun addRecipe() {
        viewModelScope.launch {
            recipeRepository.insertRecipe(
                Recipe(label = label,
                    ingredients = ingredients,
                    calories = calories)
            )
        }
    }
}