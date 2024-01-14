package com.example.cooking.UI.Favorite

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.RecipeList.RecipeList

@Composable
fun FavoritesScreen(onNavigateToRecipe:(Int)->Unit) {

    val favoritesViewModel: FavoritesScreenViewModel = viewModel()

   /* LaunchedEffect(key1 = collectionName){
        viewModel.updateCollectionName(collectionName)
    }


    */

    val recipes by favoritesViewModel.favorites.collectAsState(emptyList())
    RecipeList(
        recipeCards = recipes,
        onNavigateToRecipe = onNavigateToRecipe,
        onFavoriteButtonClicked = favoritesViewModel::onFavoriteButtonClicked,
        modifier = Modifier
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxWidth()
    )
    Log.d("FavoritesScreen", "Collected Recipes: $recipes")

}