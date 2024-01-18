package com.example.cooking.UI.RecipePage

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Composable function `DisplayRecipeScreen` displays a detailed view of a recipe based on the
 * specified recipe ID. It interacts with a [RecipePageViewModel] to fetch and observe the detailed
 * recipe information.
 *
 * @param recipeId The unique identifier of the recipe to display.
 *
 * The composable performs the following tasks:
 * - Initializes a [RecipePageViewModel] to manage and provide data for the detailed recipe view.
 * - Observes changes in the recipe data from the view model using [collectAsState].
 * - Uses a [LaunchedEffect] to update the recipe ID in the view model whenever the `recipeId`
 *   parameter changes.
 * - Displays the detailed recipe using the [RecipePage] composable.
 *
 * @see RecipePageViewModel
 * @see RecipePage
 */
@Composable
fun DisplayRecipeScreen(recipeId: String) {
    val viewModel: RecipePageViewModel = viewModel()
    val recipe by viewModel.recipe.collectAsState()
    LaunchedEffect(key1 = recipeId) {
        Log.v("RecipeId Trace","RecipeId in Launched effect: $recipeId")
        viewModel.updateRecipeId(recipeId)
    }
    RecipePage(
        recipe = recipe,
        onFavoriteButtonClicked = { recipeCard ->
            viewModel.onFavoriteButtonClicked(recipeCard)
        }
    )
}

