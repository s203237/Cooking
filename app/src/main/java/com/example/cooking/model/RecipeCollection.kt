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
    val thumbnail_url: String = "",
    val tags: List<Tag> = emptyList()
)

data class Tag(
    val name: String = "defaultName",
    val displayName: String = "defaultDisplay",
    val type: String = "defaultType"
)
fun createCardsFromDto(cardDto: List<CardDto>): List<RecipeCard> {
   val cards = cardDto.map {
       val tags = it.tags.map { tagDto ->
               Tag(
                   name = tagDto.name,
                   displayName = tagDto.displayName,
                   type = tagDto.type
               )
       }
        RecipeCard(
            id = it.recipeId,
            name = it.title,
            thumbnail_url = it.imageUrl,
            tags = tags
        )
    }
    return cards
}
