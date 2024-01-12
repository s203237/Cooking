package com.example.cooking.UI.RecipeList

import com.example.cooking.model.Tag

data class FilterButton(
    val id: Int,
    val tag: Tag,
    var isSelected: Boolean = false
)
fun getFiltersList(): List<FilterButton> {
    //TODO figure out where to put this function
    val listOfTags = listOf(
        Tag(name = "easy", displayName = "Easy", type = "Difficulty"),
        Tag(name = "5_ingredients_or_less", displayName = "5 ingredients or less", type = "Difficulty"),
        Tag(name = "dairy_free", displayName = "Dairy Free", type = "Dietary"),
        Tag(name = "gluten_free", displayName = "Gluten Free", type = "Dietary"),
        Tag(name = "asian", displayName = "Asian", type = "Cuisine")

    )

    return listOfTags.mapIndexed { index, tag ->
        FilterButton(index, tag)
    }

}