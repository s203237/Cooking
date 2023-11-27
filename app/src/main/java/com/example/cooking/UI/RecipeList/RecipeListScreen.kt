package com.example.cooking.UI.RecipeList

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.Faviorite.FavoritesScreenViewModel

/**
 * Composable function `ListAllRecipesScreen` displays a list of recipes based on the specified
 * collection name. It interacts with a [RecipeListViewModel] to fetch and observe the list of
 * recipe cards for the given collection.
 *
 * @param collectionName The name of the recipe collection to display.
 * @param onNavigateToRecipe A callback function invoked when a user navigates to view a specific
 *                           recipe. It takes the recipe ID as a parameter.
 *
 * The composable performs the following tasks:
 * - Initializes a [RecipeListViewModel] to manage and provide data for the UI.
 * - Uses a [LaunchedEffect] to update the collection name or search keywords in the view model whenever the
 *   `collectionName`or "query" parameter changes.
 * - Observes the list of recipe cards from the view model using [collectAsState].
 * - Passes the observed list of recipes to the [RecipeList] composable for display.
 * @see RecipeListViewModel
 * @see RecipeList
 */
/*@Composable
fun ListAllRecipesScreen(collectionName:String, onNavigateToRecipe: (String) -> Unit) {
    Log.v("CollectionName Trace", "RecipeId in viewModel.launch: $collectionName")
    val viewModel: RecipeListViewModel = viewModel()
    LaunchedEffect(key1 = collectionName){
        viewModel.updateCollectionName(collectionName)
    }
    val recipes by viewModel.recipeCards.collectAsState()

    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = onNavigateToRecipe,onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked
    )
}
@Composable
fun ListAllRecipes(query:String, onNavigateToRecipe: (String) -> Unit) {

    Log.v("Recipes Trace", "RecipeId in viewModel.launch: $query")
    val viewModel: RecipeListViewModel = viewModel()
    LaunchedEffect( key1 = query){
        viewModel.updateSearchKey(query)
    }
    val recipes by viewModel.recipeCards.collectAsState()
    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = onNavigateToRecipe, onFavoriteButtonClicked = {}
    )
}*/
@Composable
fun ListAllRecipesScreen(collectionName: String, onNavigateToRecipe: (String) -> Unit) {
    Log.v("CollectionName Trace", "RecipeId in viewModel.launch: $collectionName")

    // Create a reference to the FavoritesScreenViewModel
    val favoritesViewModel: FavoritesScreenViewModel = viewModel()

    val viewModel: RecipeListViewModel = viewModel()
    LaunchedEffect(key1 = collectionName) {
        viewModel.updateCollectionName(collectionName)
    }

    val recipes by viewModel.recipeCards.collectAsState()

    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = onNavigateToRecipe,
        onFavoriteButtonClicked = { imageUrl ->
            // Use the FavoritesScreenViewModel when handling the favorite button click
            favoritesViewModel.onFavoriteButtonClicked(imageUrl)
        }
    )
}

@Composable
fun ListAllRecipes(query: String, onNavigateToRecipe: (String) -> Unit) {
    Log.v("Recipes Trace", "RecipeId in viewModel.launch: $query")

    // Create a reference to the FavoritesScreenViewModel
    val favoritesViewModel: FavoritesScreenViewModel = viewModel()

    val viewModel: RecipeListViewModel = viewModel()
    LaunchedEffect(key1 = query) {
        viewModel.updateSearchKey(query)
    }

    val recipes by viewModel.recipeCards.collectAsState()

    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = onNavigateToRecipe,
        onFavoriteButtonClicked = { /* handle the click as needed */ }
    )
}
