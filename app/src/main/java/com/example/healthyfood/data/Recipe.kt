package com.example.healthyfood.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class edamamResponse(
    @SerialName("hits") val hits: Array<Hit>
)
@Serializable
data class Hit(
    @SerialName("recipe") val recipe: Recipe
)
@Serializable
data class Recipe(
    @SerialName("label") val label: String,
    @SerialName("calories") val calories: Double
)