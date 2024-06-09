package com.example.healthyfood.data.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepository(private val recipeDao: RecipeDao) {
    suspend fun getRecipes() {
        withContext(Dispatchers.IO) {
            recipeDao.getAll()
        }
    }
    suspend fun insertRecipe(recipe: Recipe) {
        //withContext(Dispatchers.IO) {
            recipeDao.insert(recipe)
        //}
    }
    suspend fun deleteRecipe(recipe: Recipe) {
        withContext(Dispatchers.IO) {
            recipeDao.delete(recipe)
        }
    }
    suspend fun updateRecipe(recipe: Recipe) {
        withContext(Dispatchers.IO) {
            recipeDao.update(recipe)
        }
    }
}