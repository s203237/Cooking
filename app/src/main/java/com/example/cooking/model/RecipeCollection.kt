package com.example.cooking.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeCollection(
    val collectionName: String = "Default Collection",
    val results: List<RecipeCard> = emptyList()
)
@Serializable
data class RecipeCard(
    val recipeId: String = "defaultID",
    val name: String = "defaultName",
    val thumbnail_url: String = ""
)
