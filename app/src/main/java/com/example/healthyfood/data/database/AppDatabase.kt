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

    /*companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }*/
}

object DB {
    private lateinit var applicationContext: Context

    fun init(context: Context) {
        applicationContext = context
    }

    val appDatabase: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            //.createFromAsset("room_article.db")
            .build()
    }
}