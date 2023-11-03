package com.example.cooking.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class RecipeDto(
    @SerialName("name")
    val title: String,

    @SerialName("imageSrc")
    val imageUrl: String,

    val imageDescription: String,

    @SerialName("recipeAuthor")
    val author: String,

    @SerialName("Prep")
    val prepTime: Int,

    @SerialName("Cook")
    val cookingTime: Int,

    @SerialName("portions")
    val servingSize: Int,

    val difficulty: String,

    val rating: Float,

    @SerialName("description")
    val recipeDescription: String,

    val ingredients: List<String>,
    val steps: List<String>
)


/* NOTES ON DTO'S (DATA TRANSFER OBJECTS)
* Design pattern used to help structure (encapsulate) data to be transferred between
* different parts of the application or in our case from the API on the Internet and to our app.
*
* The @SerialName annotation specifies the name of the serialized field in the JSON
* Here we are mapping our 'id' val to the field name '_id' (underscores are not part of
* the naming convention)
* */

