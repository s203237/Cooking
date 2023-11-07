package com.example.cooking.UI.RecipePage

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DisplayRecipeScreen(recipeId: String) {
    val viewModel: RecipePageViewModel = viewModel()
    val recipe by viewModel.recipe.collectAsState()
    println("Displaying Recipe Screen")
    //TODO update viewModel recipeId with arguement passed to DisplayRecipeScreen
    LaunchedEffect(key1 = recipeId) {
        Log.v("RecipeId Trace","RecipeId in Launched effect: $recipeId")
        viewModel.updateRecipeId(recipeId)
    }
    RecipePage(recipe = recipe)
}