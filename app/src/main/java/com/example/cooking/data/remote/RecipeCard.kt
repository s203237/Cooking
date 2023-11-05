package com.example.cooking.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeCard(
    val recipeId: String,
    @SerialName("name")
    val title: String,
    @SerialName("imageSrc")
    val imageUrl: String,
    val imageDescription: String,
)
