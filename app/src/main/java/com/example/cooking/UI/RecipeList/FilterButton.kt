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
        Tag(name = "dairy_free", displayName = "Dairy Free", type = "Dietary"),
        Tag(name = "gluten_free", displayName = "Gluten Free", type = "Dietary"),
        Tag(name = "vegan", displayName = "Vegan", type = "Dietary"),
        Tag(name = "low_carb", displayName = "low-carb", type = "Dietary"),
        Tag(name = "indulgent_sweets", displayName = "Sweet", type = "Dietary"),
        Tag(name = "5_ingredients_or_less", displayName = "5 ingredients or less", type = "Difficulty"),
        Tag(name = "under_30_minutes", displayName = "< 30 min", type = "Difficulty"),
        Tag(name = "easy", displayName = "Easy", type = "Difficulty"),
        Tag(name = "asian", displayName = "Asian", type = "Cuisine"),
        Tag(name = "middle_eastern", displayName = "Middle Eastern", type = "Cuisine"),
        Tag(name = "american", displayName = "American", type = "Cuisine"),
        Tag(name = "italian", displayName = "Italian", type = "Cuisine"),
        Tag(name = "mexican", displayName = "Mexican", type = "Cuisine"),
        Tag(name = "dominican", displayName = "Dominican", type = "Cuisine"),
        Tag(name = "puerto_rican", displayName = "Puerto Rican", type = "Cuisine"),
        Tag(name = "greek", displayName = "Greek", type = "Cuisine"),
        Tag(name = "indian", displayName = "Indian", type = "Cuisine"),
        Tag(name = "ethiopian", displayName = "Ethiopian", type = "Cuisine"),


    )

    return listOfTags.mapIndexed { index, tag ->
        FilterButton(index, tag)
    }

}