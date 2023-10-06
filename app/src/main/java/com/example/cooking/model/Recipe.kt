package com.example.cooking.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RecipeCard(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    val ingredients: List<String>,
    val steps: List<String>
)
