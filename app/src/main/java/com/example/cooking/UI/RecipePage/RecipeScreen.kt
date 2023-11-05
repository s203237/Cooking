package com.example.cooking.UI.RecipePage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DisplayRecipeScreen() {
    val viewModel: RecipePageViewModel = viewModel()
    val recipe by viewModel.recipe.collectAsState()
    RecipePage(recipe = recipe)
}