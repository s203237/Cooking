package com.example.cooking.model

import com.example.cooking.data.remote.CardDto


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
data class RecipeCollection(
    val collectionName: String = "Default Collection",
    val results: List<RecipeCard> = emptyList(),
    var type: ListType = ListType.VERTICAL
)
data class RecipeCard(
    val id: Int = 0,
    val name: String = "defaultName",
    val thumbnail_url: String = ""
)

fun createCardsFromDto(dto: List<CardDto>): List<RecipeCard> {
   val cards = dto.map {
        RecipeCard(
            id = it.recipeId,
            name = it.title,
            thumbnail_url = it.imageUrl
        )
    }

    return cards
}
