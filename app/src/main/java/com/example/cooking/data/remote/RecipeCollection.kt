package com.example.cooking.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeCollection(
    val collectionName: String = "Default Collection",
    val results: List<RecipeCard> = emptyList()
)
@Serializable
data class RecipeCard(
    val recipeId: String = "defaultId",
    @SerialName("recipeName")
    val title: String = "Default title",
    @SerialName("imageSrc")
    val imageUrl: String = "",
    //val imageDescription: String, TODO get image description
)

@Serializable
data class RecipeSingleCard(
    val collectionName: String = "Default Collection",
    val results: RecipeCard = RecipeCard()
)