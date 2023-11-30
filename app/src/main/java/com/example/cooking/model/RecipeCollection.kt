package com.example.cooking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeCollection(
    val collectionName: String = "Default Collection",
    val results: List<RecipeCard> = emptyList()
)
/*
@Serializable
data class RecipeCard(
    val recipeId: String = "defaultId",

    @SerializedName("recipeName")
    val title: String = "Default title",

    @SerializedName("imageSrc")
    val imageUrl: String = "",
    //val imageDescription: String, TODO get image description
)
*/

@Serializable
data class RecipeCard(
    val recipeId: String = "defaultId",
    var isFavorite: Boolean = false,
    @SerialName("recipeName")
    val title: String = "Default title",
    @SerialName("imageSrc")
    val imageUrl: String = "",
    //val imageDescription: String, TODO get image description
)
