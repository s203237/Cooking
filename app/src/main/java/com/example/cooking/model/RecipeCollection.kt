package com.example.cooking.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*enum class ListType(listType: Int) {
    HORIZONTAL(0),
    VERTICAL(1),
    CARD(2),
    GRID(3)
}*/
enum class ListType {
    HORIZONTAL,
    VERTICAL,
    CARD
}
@Serializable
data class RecipeCollection(
    @SerialName("")
    val collectionName: String = "Default Collection",
    val results: List<RecipeCard> = emptyList(),
    var type: ListType = ListType.VERTICAL
)

@Serializable
data class RecipeCard(
    val id: Int = 0,
    val name: String = "defaultName",
    val thumbnail_url: String = "",
    var isFavorite: Boolean = false
)


/*@Serializable
data class RecipeCard(
    val recipeId: Int = 0,
    var isFavorite: Boolean = false,
    @SerialName("recipeName")
    val title: String = "Default title",
    @SerialName("imageSrc")
    val imageUrl: String = "",
    //val imageDescription: String, TODO get image description
)*/
