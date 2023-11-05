package com.example.cooking.data.remote
import com.example.cooking.model.Recipe
import kotlinx.serialization.json.Json

fun getRecipeObjects(recipesListJson: List<String>): List<Recipe> {
    //val recipeString = recipesListJson.joinToString() //TODO figure out how not to have to make it a single string
    //return Json.decodeFromString(recipeString)
    val recipes = mutableListOf<Recipe>()
    for(recipe in recipesListJson)
        recipes.add(Json.decodeFromString(recipe))
    return recipes
}

fun getRecipeCardObjects(recipesListJson: List<String>): List<RecipeCard> {
    //val recipeString = recipesListJson.joinToString() //TODO figure out how not to have to make it a single string
    //return Json.decodeFromString(recipeString)
    val recipeCards = mutableListOf<RecipeCard>()
    for(recipe in recipesListJson)
        recipeCards.add(Json.decodeFromString(recipe))
    return recipeCards
}