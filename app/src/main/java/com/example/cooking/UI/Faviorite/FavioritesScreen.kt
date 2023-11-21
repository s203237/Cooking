package com.example.cooking.UI.Faviorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel;
import com.example.cooking.UI.RecipeList.RecipeItem
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.cooking.UI.NavBar.navigation.Navigator.navController
import com.example.cooking.UI.RecipeList.RecipeList


@Composable
fun FavoritesScreen(onNavigateToRecipe: (String) -> Unit) {
    val viewModel: FavoritesScreenViewModel = viewModel()

   /* LaunchedEffect(key1 = collectionName){
        viewModel.updateCollectionName(collectionName)
    }*/
    val recipes by viewModel.favorites.collectAsState(emptyList())

    RecipeList(recipes = recipes , onNavigateToRecipe = onNavigateToRecipe , onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked)
}
@Preview
@Composable
fun FavoriteScreenPreview(){

    FavoritesScreen(onNavigateToRecipe = { recipeId ->
        navController.navigate(route = "Screens.RecipeItem.name/$recipeId")})
}