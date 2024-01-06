package com.example.cooking.UI.Faviorite

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.RecipeList.RecipeList

@Composable
fun FavoritesScreen(onNavigateToRecipe:(String)->Unit) {

    val favoritesViewModel: FavoritesScreenViewModel = viewModel()

   /* LaunchedEffect(key1 = collectionName){
        viewModel.updateCollectionName(collectionName)
    }


    */

    val recipes by favoritesViewModel.favorites.collectAsState(emptyList())
    RecipeList(recipes = recipes , onNavigateToRecipe =onNavigateToRecipe  , onFavoriteButtonClicked = favoritesViewModel::onFavoriteButtonClicked)
    Log.d("FavoritesScreen", "Collected Recipes: $recipes")

}