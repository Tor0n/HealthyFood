package com.example.healthyfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthyfood.ui.theme.HealthyFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HealthyFoodApp()
        }
    }
}
@Preview
@Composable
fun preview() {
    RecipeList(modifier = Modifier.padding(4.dp), recipes = TestData.RecipesList)
}
data class Recipe(val name: String)
@Composable
fun RecipeCard(recipe: Recipe) {
    Row(modifier = Modifier.padding(all = 4.dp)) {
        Text(
            text = recipe.name
        )
    }
}
@Composable
fun RecipeList(modifier: Modifier, recipes: List<Recipe>) {
    LazyColumn(modifier = modifier) {
        items(recipes) {recipe ->
            RecipeCard(recipe)
        }
    }
}

