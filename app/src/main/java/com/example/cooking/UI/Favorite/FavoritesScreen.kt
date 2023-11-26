package com.example.cooking.UI.Faviorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cooking.UI.RecipeList.RecipeList


@Composable
fun FavoritesScreen(
    onNavigateToFavorite: (String) -> Unit,
    collectionName: String,
    navController: NavController // Make sure to include NavController as a parameter
) {
    val viewModel: FavoritesScreenViewModel = viewModel()

    // ...
    val recipes by viewModel.favorites.collectAsState(emptyList())
    RecipeList(
        recipes = recipes,
        onNavigateToRecipe = { recipeId ->
            val route = "Favorites/$collectionName/$recipeId"
            onNavigateToFavorite(route)
            // Alternatively, if you want to navigate directly:
            // navController.navigate(route)
        },
        onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked
    )
}

/*fun FavoritesScreen(onNavigateToFavorite: (String) -> Unit, collectionName: String) {

    val viewModel: FavoritesScreenViewModel = viewModel()

    /* LaunchedEffect(key1 = collectionName){
         viewModel.updateCollectionName(collectionName)
     }*/

    val recipes by viewModel.favorites.collectAsState(emptyList())

    RecipeList(recipes = recipes , onNavigateToRecipe = {
                                                        navController.navigate(("Favorites/$collectionName"))
    }, onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked)
}*/

