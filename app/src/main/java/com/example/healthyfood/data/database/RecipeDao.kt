package com.example.healthyfood.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>
    @Query("SELECT * FROM recipe WHERE label LIKE :label")
    fun getByLabel(label: String): Recipe

    @Insert
    fun insert(vararg recipe: Recipe)
    @Delete
    fun delete(recipe: Recipe)
    @Update
    fun update(vararg recipe: Recipe)
}