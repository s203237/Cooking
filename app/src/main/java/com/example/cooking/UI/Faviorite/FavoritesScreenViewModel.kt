package com.example.cooking.UI.Faviorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/*class FavoritesScreenViewModel: ViewModel() {


    private val favoritesDataSource = DependencyProvider.favoritesDataSource
    val favorites : Flow<List<RecipeCard>> = favoritesDataSource
        .getFavorites()
        .map { recipeCard ->
            Log.d("FavoritesVM", "Fetching favorites")
            recipeCard.map {
                RecipeCard(isFavorite = true, thumbnail_url = it.thumbnail_url, id = it.id , name = it.name )
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

    fun onFavoriteButtonClicked(recipeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("FavoritesVM", "Toggling favorite for recipeId: $recipeId")
           favoritesDataSource.toggleFavorite(recipeId)
            Log.d("onFavoriteButtonClicked called with " ,"imageUrl: $recipeId")
        }
    }


}*/
class FavoritesScreenViewModel: ViewModel() {

    private val favoritesDataSource = DependencyProvider.favoritesDataSource

    val favorites: Flow<List<RecipeCard>> = favoritesDataSource
        .getFavorites()
        .map { recipeCards ->
            Log.d("FavoritesVM", "Fetching favorites")
            // Log the raw data received from the data source
            Log.d("FavoritesVM", "Raw favorites data: $recipeCards")

            recipeCards.map { recipeCard ->
                RecipeCard(isFavorite = true, thumbnail_url = recipeCard.thumbnail_url, id = recipeCard.id, name = recipeCard.name).also {
                    // Log each mapped RecipeCard
                    Log.d("FavoritesVM", "Mapped RecipeCard: $it")
                }
            }.also {
                // Log the final list after mapping
                Log.d("FavoritesVM", "Final mapped favorites list: $it")
            }
        }

    fun onFavoriteButtonClicked(recipeCard: RecipeCard) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("FavoritesVM", "Toggling favorite for recipeId: $recipeCard")
            favoritesDataSource.toggleFavorite(recipeCard)
            Log.d("FavoritesVM", "Favorite toggled for recipeId: $recipeCard")
        }
    }
}




/*class FavoritesScreenViewModel : ViewModel() {
    private val favoritesDataSource = DependencyProvider.favoritesDataSource

    private val _favoritesUpdateTrigger = MutableStateFlow(Unit)
    val favorites: Flow<List<RecipeCard>> = _favoritesUpdateTrigger.flatMapLatest {
        favoritesDataSource.getFavorites()
    }.map { recipeCardList ->
        recipeCardList.map { recipeCard ->
            RecipeCard(isFavorite = true, thumbnail_url = recipeCard.thumbnail_url, id = recipeCard.id, name = recipeCard.name)
        }
    }

    fun onFavoriteButtonClicked(recipeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesDataSource.toggleFavorite(recipeId)
            _favoritesUpdateTrigger.value = Unit // Trigger refresh
            Log.d("FavoritesScreenViewModel", "Favorite toggled for recipeId: $recipeId")
        }
    }
}*/



