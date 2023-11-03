package com.example.cooking.UI.RecipeList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ListAllRecipesScreen() {
    val viewModel: RecipeListViewModel = viewModel()
    val recipes by viewModel.recipes.collectAsState()
    RecipeList(recipes = recipes, onNavigateToRecipe = {}) //TODO implement onNavigateToRecipe
}