package com.example.cooking.UI.RecipePage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DisplayRecipeScreen(recipeId: String) {
    val viewModel: RecipePageViewModel = viewModel()
    val recipe by viewModel.recipe.collectAsState()
    //TODO update viewModel recipeId with arguement passed to DisplayRecipeScreen
    RecipePage(recipe = recipe)
}