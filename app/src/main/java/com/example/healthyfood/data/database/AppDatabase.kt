package com.example.healthyfood.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [Recipe::class]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}

object DB {
    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    private val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            //.createFromAsset("room_article.db")
            .build()
    }
}