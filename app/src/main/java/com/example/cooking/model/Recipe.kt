package com.example.cooking.model

import androidx.annotation.DrawableRes

data class Recipe(
    val title: String,
    @DrawableRes val mainImage: Int,
    val imageDescription: String,
    val prepTime: Int,
    val cookingTime: Int,
    val servingSize: Int,
    val difficulty: String,
    val recipeDescription: String,
    val ingredients: List<String>,
    val steps: List<String>
)

