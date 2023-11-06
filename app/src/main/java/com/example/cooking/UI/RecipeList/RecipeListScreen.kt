package com.example.cooking.UI.RecipeList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import android.util.Log
@Composable
fun ListAllRecipesScreen() {
    val viewModel: RecipeListViewModel = viewModel()
    val recipes by viewModel.recipeCards.collectAsState()
    println("In ListAllRecipesScreen")
    RecipeList(recipes = recipes, onNavigateToRecipe = {/*recipeId -> viewModel.getCollectionName()}, onRecipeFavored = viewModel::getCollectionName*/}) //TODO implement onNavigateToRecipe

}