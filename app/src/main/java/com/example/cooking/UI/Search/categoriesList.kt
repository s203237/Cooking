package com.example.cooking.UI.Search

import androidx.compose.runtime.Composable
import com.example.cooking.model.Tag

@Composable
fun CategoriesList(): List<Tag>{
    return listOf(
        Tag(name = "salad", displayName = "Salad"),
        Tag(name = "dessert", displayName = "Dessert"),
        Tag(name = "dinner", displayName = "Dinner"),
        Tag(name = "lunch", displayName = "Lunch"),
        Tag(name = "breakfast", displayName = "Breakfast"),
        Tag(name = "healthy", displayName = "Healthy"),
        Tag(name = "easy", displayName = "Easy"),
        Tag(name = "under_30_minutes", displayName = "Under 30 minutes"),
        Tag(name = "5_ingredients_or_less", displayName = "5 ingredients or less"),
        Tag(name = "vegan", displayName = "Vegan"),
    )

}