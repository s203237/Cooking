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
    var isFavorite: Boolean = false,
    var isDailyRecipe:Boolean=false
)
/*{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecipeCard

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}*/


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
