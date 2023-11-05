package com.example.cooking.data.remote
import com.example.cooking.model.Recipe
import kotlinx.serialization.json.Json

fun getRecipeInstance(recipeJson: String): Recipe {
    return Json.decodeFromString(recipeJson)
}

fun getRecipeCardInstances(recipesListJson: List<String>): List<RecipeCard> {
    //val recipeString = recipesListJson.joinToString() //TODO figure out how not to have to make it a single string
    //return Json.decodeFromString(recipeString)
    val recipeCards = mutableListOf<RecipeCard>()
    for(recipe in recipesListJson)
        recipeCards.add(Json.decodeFromString(recipe))
    return recipeCards
}