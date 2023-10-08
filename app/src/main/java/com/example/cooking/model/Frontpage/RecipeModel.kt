package com.example.cooking.model.Frontpage

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class RecipeModel(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
