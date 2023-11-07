package com.example.cooking.data.remote.mock_datasource
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import kotlinx.serialization.json.Json

fun getRecipeInstance(recipeJson: String): Recipe {
    return Json.decodeFromString(recipeJson)
}

fun getRecipeCardInstances(recipesListJson: List<String>): List<RecipeCard> {
    val recipeCards = mutableListOf<RecipeCard>()
    for(recipe in recipesListJson)
        recipeCards.add(Json.decodeFromString(recipe))
    return recipeCards
}