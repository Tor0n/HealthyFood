package com.example.healthyfood.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthyfood.data.Recipe
import com.example.healthyfood.network.HealthyFoodApi
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.IOException

sealed interface SearchUiState {
    data class Success(val recipes: Array<Recipe>) : SearchUiState
    object Error : SearchUiState
    object Loading : SearchUiState
}

class SearchViewModel :ViewModel() {
    var searchUiState: SearchUiState by mutableStateOf(SearchUiState.Loading)
        private set

    init {
        getSearchRecipes()
    }

    fun getSearchRecipes() {
        viewModelScope.launch {
            searchUiState = try {
                //val listResult = listOf(Json.decodeFromString<Recipe>(HealthyFoodApi.retrofitService.getRecipes()))
                val listResult = Json{ ignoreUnknownKeys = true }.decodeFromString<Array<Recipe>>(HealthyFoodApi.retrofitService.getRecipes())
                //val listResult = listOf<Recipe>(Json.decodeFromString<Recipe>(EdamamResponse.Companion.toString()))
                //val listResult = HealthyFoodApi.retrofitService.getRecipes()
                SearchUiState.Success(listResult)
            } catch (e: IOException) {
                SearchUiState.Error
            }
        }
    }
}