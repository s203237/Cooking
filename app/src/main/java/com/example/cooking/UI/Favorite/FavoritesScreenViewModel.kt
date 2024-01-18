package com.example.cooking.UI.Favorite

import android.util.Log
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

    val favorites: Flow<List<RecipeCard>> = favoritesDataSource
        .getFavorites()
        .map { card ->
            card.map {
                RecipeCard(
                    id = it.id,
                    name = it.name,
                    thumbnail_url = it.thumbnail_url,
                    tags = it.tags,
                    isFavorite = true
                )
            }

        }

    fun onFavoriteButtonClicked(recipeCard: RecipeCard) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                favoritesDataSource.toggleFavorite(recipeCard)
               // refreshFavorites() // Refresh the favorites list after toggling the status
            } catch (e: Exception) {
                Log.e("FavoritesScreenViewModel", "Error toggling favorite: $e")
            }
        }
    }
}
