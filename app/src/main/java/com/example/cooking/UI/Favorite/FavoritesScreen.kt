package com.example.cooking.UI.Faviorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.RecipeList.RecipeList
import com.example.cooking.model.RecipeCard


@Composable
fun FavoritesScreen(
    //favorites: List<RecipeCard>,
    onNavigateToRecipe: (String) -> Unit  )
{
    val viewModel: FavoritesScreenViewModel = viewModel()

    // ...
    val recipes by viewModel.favorites.collectAsState(emptyList())
    RecipeList(
        recipes = recipes,
        /*onNavigateToRecipe = { recipeId ->
            //val route = "Favorites/$collectionName/$recipeId"
            val route = "Screens.RecipeItem.name/$recipeId"
            onNavigateToRecipe(route)

            // Alternatively, if you want to navigate directly:
            // navController.navigate(route)
        },*/
        onNavigateToRecipe = onNavigateToRecipe,
        onFavoriteButtonClicked = { recipeId ->
            toggleFavorite(recipeId.recipeId)
        }//viewModel::onFavoriteButtonClicked
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

