package com.example.healthyfood.data.database

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Singleton

@Singleton
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

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: RecipeRepository? = null
        fun getInstance(recipeDao: RecipeDao) =
            instance ?: synchronized(this) {
                instance ?:RecipeRepository(recipeDao).also { instance = it }
            }
    }
}