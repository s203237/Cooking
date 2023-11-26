package com.example.cooking.UI.Faviorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.RecipeList.RecipeList


@Composable
fun FavoritesScreen() {

    val viewModel: FavoritesScreenViewModel = viewModel()

   /* LaunchedEffect(key1 = collectionName){
        viewModel.updateCollectionName(collectionName)
    }


    */

    val recipes by viewModel.favorites.collectAsState(emptyList())
    RecipeList(recipes = recipes , onNavigateToRecipe = {}, onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked)


}