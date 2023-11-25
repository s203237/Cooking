package com.example.cooking.UI.Faviorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch



class FavoritesScreenViewModel: ViewModel() {

    private val favoritesDataSource = DependencyProvider.favoritesDataSource
    val favorites : Flow<List<RecipeCard>> = favoritesDataSource
        .getFavorites()
        .map { imageUrls ->
            imageUrls.map {
                RecipeCard(isFavorite = true, imageUrl = it)
            }
        }
    /*private val favoritesDataSource = DependencyProvider.favoritesDataSource

    val favorites: Flow<Recipe> = favoritesDataSource
        .getFavorites()
        .flatMapConcat { imageUrls ->
            flow {
                imageUrls.forEach { imageUrl ->
                    emit(Recipe(isFavorite = true, imageUrl = imageUrl))
                }
            }
        }*/

    fun onFavoriteButtonClicked(imageUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
           favoritesDataSource.toggleFavorite(imageUrl)
        }
    }


}


