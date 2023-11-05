package com.example.cooking.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable
@Serializable
data class Recipe(
    val title: String,
    @DrawableRes val imageUrl: Int,
    val imageDescription: String,
    val author: String,
    val prepTime: Int,
    val cookingTime: Int,
    val servingSize: Int,
    val difficulty: String,
    val rating: Float,
    val recipeDescription: String,
    val ingredients: List<String>,
    val steps: List<String>
)

