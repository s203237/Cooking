package com.example.cooking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class Recipe(
    val recipeId: String = "defaultId",
    @SerialName("name")
    val title: String = "Default title",
    @SerialName("imageSrc")
    val imageUrl: String = "",

    val imageDescription: String = "Default description",

    @SerialName("recipeAuthor")
    val author: String = "Default author",

    val timeToCook: TimeToCook = TimeToCook(),

    val difficulty: String = "Default difficulty",

    @SerialName("portions")
    val servingSize: String = "0",

    val rating: Float = 0f,

    @SerialName("description")
    val recipeDescription: String = "Default description",

    val ingredients: List<String> = emptyList(),
    val steps: Map<String,String> = emptyMap(),
    val isFavorite: Boolean =false,
    /* val title: String = "Default Title",
     @DrawableRes val imageUrl: Int = 0,
     val imageDescription: String = "",
     val author: String = "Default Author",
     val prepTime: Int = 0,
     val cookingTime: Int = 0,
     val servingSize: Int = 0,
     val difficulty: String = "",
     val rating: Float = 0.0f,
     val recipeDescription: String = "Default Description",
     val ingredients: List<String> = emptyList(),
     val steps: List<String> = emptyList()*/
)

@Serializable
data class Steps (
    @SerialName("id")
    val id: Int
)

@Serializable
data class TimeToCook (
    @SerialName("Cook")
    val cookTime: String = "0 min",

    @SerialName("Prep")
    val prepTime: String = "0 min",

    )
