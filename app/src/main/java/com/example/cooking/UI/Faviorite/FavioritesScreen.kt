package com.example.cooking.UI.Faviorite

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel;
import com.example.cooking.UI.RecipeList.RecipeListViewModel;

@Composable
fun FavoritesScreen() {
    val viewModel: FavoritesScreenViewModel = viewModel()
    //val recipes by viewModel.favorites.collectAsState(emptyList())
}