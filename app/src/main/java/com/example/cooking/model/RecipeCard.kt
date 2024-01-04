package com.example.cooking.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeCard(
    val id: Int = 0,
    val name: String = "defaultName",
    val thumbnail_url: String = ""
)