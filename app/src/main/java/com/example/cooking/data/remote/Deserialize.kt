package com.example.cooking.data.remote
import com.example.cooking.model.Recipe
import kotlinx.serialization.json.Json

fun getRecipeObjects(recipesListJson: List<String>): List<Recipe> {
    val recipeString = recipesListJson.joinToString() //TODO figure out how not to have to make it a single string
    return Json.decodeFromString(recipeString)
}