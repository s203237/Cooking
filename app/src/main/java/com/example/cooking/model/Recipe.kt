package com.example.cooking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class Recipe(
//    val recipeId: String = "defaultId",
//    @SerialName("name")
//    val title: String = "Default title",
//
//    @SerialName("imageSrc")
//    val imageUrl: String = "",
//
//    val imageDescription: String = "Default description",
//
//    @SerialName("recipeAuthor")
//    val author: String = "Default author",
//
//    val timeToCook: TimeToCook = TimeToCook(),
//
//    val difficulty: String = "Default difficulty",
//
//    @SerialName("portions")
//    val servingSize: String = "0",
//
//    val rating: Float = 0f,
//
//    @SerialName("description")
//    val recipeDescription: String = "Default description",
//
//    val ingredients: List<String> = emptyList(),
//    val steps: Map<String,String> = emptyMap()
//    /* val title: String = "Default Title",
//     @DrawableRes val imageUrl: Int = 0,
//     val imageDescription: String = "",
//     val author: String = "Default Author",
//     val prepTime: Int = 0,
//     val cookingTime: Int = 0,
//     val servingSize: Int = 0,
//     val difficulty: String = "",
//     val rating: Float = 0.0f,
//     val recipeDescription: String = "Default Description",
//     val ingredients: List<String> = emptyList(),
//     val steps: List<String> = emptyList()*/

    val id: Int = 0,
    val name: String = "Default title",
    val thumbnail_url: String = "",
    val thumbnail_alt_text: String = "Default description",
    val author: String = "Default author", //TODO: need rework auther=credits
    val cook_time: TimeToCook = TimeToCook(), //TODO: look at this maybe not working with this API
    val difficulty: String = "Default difficulty", //TODO: look at this maybe not working with this API
    val num_servings: Int = 0,
    val score: Float = 0f, //TODO: Rating works differently maybe rework this? rating
    val description: String = "Default description",
    val ingredients: List<String> = emptyList(), //TODO: This need to be implemented
    val steps: Map<String,String> = emptyMap() //TODO: need rework
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
