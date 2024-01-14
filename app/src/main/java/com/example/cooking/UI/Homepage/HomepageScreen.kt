package com.example.cooking.UI.Homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.Favorite.FavoritesScreenViewModel


@Composable
fun HomepageScreen(onNavigateToRecipe: (Int) -> Unit){
    val viewModel: HomePageViewModel = viewModel()
    val collections by viewModel.recipeCollections.collectAsState()
    val dailyRecipe by viewModel.dailyRecipe.collectAsState()
    val favoritesViewModel: FavoritesScreenViewModel = viewModel()
    val favorites by favoritesViewModel.favorites.collectAsState()

    scrollableList(
            modifier = Modifier
                .background(color = Color(0xFFF2ECE3))
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            dailyRecipe = dailyRecipe,
            listOfCollections = collections,
            onNavigateToRecipe = onNavigateToRecipe,
        onFavoriteButtonClicked = viewModel::onFavoriteButtonClicked

    )

}

