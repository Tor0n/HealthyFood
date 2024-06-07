package com.example.healthyfood.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true) val rID: Long,
    @ColumnInfo(name = "label") val label: String,
    @ColumnInfo(name = "calories") val calories: Double
)
