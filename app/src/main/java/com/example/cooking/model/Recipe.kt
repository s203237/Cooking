package com.example.cooking.model

import androidx.annotation.DrawableRes

data class Recipe(
    val title: String,
    @DrawableRes val mainImage: Int,
    val contentDescription: String,
    val ingredients: List<String>,
    val steps: List<String>
)
