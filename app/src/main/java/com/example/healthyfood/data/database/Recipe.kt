package com.example.healthyfood.data.database

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true) var rID: Int = 0,
    @ColumnInfo(name = "label") val label: String,
    @ColumnInfo(name = "ingredients") val ingredients: List<String>,
    @ColumnInfo(name = "calories") val calories: Double
)

data class RecipeQ(
    val label: String,
    val ingredients: List<String>,
    val calories: Double,
    val image: Int
)
