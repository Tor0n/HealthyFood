package com.example.healthyfood.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true) var rID: Int = 0,
    @ColumnInfo(name = "label") val label: String,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "calories") val calories: Double
)
