package com.example.cooking.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeCollection(
    val collectionName: String = "Default Collection",
    val results: List<RecipeCard> = emptyList()
)
@Serializable
data class RecipeCard(
/*
    val recipeId: String = "defaultId",

    @SerializedName("name")
    val title: String = "Default title",

    @SerializedName("thumbnail_url")
    val imageUrl: String = "",
    //val imageDescription: String, TODO get image description
*/
val recipeId: String = "test1",
val name: String = "test2",
val thumbnail_url: String = "test3"

)



