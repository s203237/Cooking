package com.example.cooking.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionDto(
val results: List<CardDto> = emptyList()
)

@Serializable
data class CardDto(
    @SerialName("id")
    val recipeId: Int = 0,
    @SerialName("name")
    val title: String = "Default title",
    @SerialName("thumbnail_url")
    val imageUrl: String = "",
    //val imageDescription: String, TODO get image description
)
