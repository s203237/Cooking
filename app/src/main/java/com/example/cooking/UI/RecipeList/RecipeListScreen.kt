package com.example.cooking.UI.RecipeList

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import android.util.Log
@Composable
fun ListAllRecipesScreen(onNavigateToRecipe: (String) -> Unit) {
    val viewModel: RecipeListViewModel = viewModel()
    val recipes by viewModel.recipeCards.collectAsState()
    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = onNavigateToRecipe,
        /*{recipeId -> viewModel.getCollectionName()},
        onRecipeFavored = viewModel::getCollectionName*/

    ) //TODO implement onNavigateToRecipe

}