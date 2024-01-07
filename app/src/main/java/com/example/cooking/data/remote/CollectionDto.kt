package com.example.cooking.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionDto(
val collectionName: String = "Default Collection",
val results: List<CardDto> = emptyList()
)

@Serializable
data class CardDto(
    val recipeId: String = "defaultId",
    @SerialName("recipeName")
    val title: String = "Default title",
    @SerialName("imageSrc")
    val imageUrl: String = "",
    //val imageDescription: String, TODO get image description
)
