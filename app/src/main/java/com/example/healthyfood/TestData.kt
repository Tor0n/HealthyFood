package com.example.healthyfood

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.core.content.res.ResourcesCompat
import com.example.healthyfood.data.database.RecipeQ

object testDataHome {
    val RecipesList = listOf(
        RecipeQ(label = "Rotisserie Chicken Recipe",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.rotisseriechickenrecipe),
        RecipeQ(label = "Dishesh2",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.ic_launcher_foreground),
        RecipeQ(label = "Dishesh3",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.ic_launcher_foreground),
        RecipeQ(label = "Dishesh4",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.ic_launcher_foreground),
        RecipeQ(label = "Dishesh5",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.ic_launcher_foreground),
        RecipeQ(label = "Dishesh6",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.ic_launcher_foreground),
        RecipeQ(label = "Dishesh7",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.ic_launcher_foreground),
        RecipeQ(label = "Dishesh8",
            ingredients = listOf("1 whole chicken, about 4 pounds",
                "2 tablespoons kosher salt",
                "2 tablespoons butter, melted"),
            calories = 2856.23,
            image = R.drawable.ic_launcher_foreground),
    )
}