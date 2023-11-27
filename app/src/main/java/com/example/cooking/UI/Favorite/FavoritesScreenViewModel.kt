package com.example.cooking.UI.Faviorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch



class FavoritesScreenViewModel: ViewModel() {


    private val favoritesDataSource = DependencyProvider.favoritesDataSource

    private val _recipeCards = MutableStateFlow<List<RecipeCard>>(emptyList())
    val recipeCards: StateFlow<List<RecipeCard>> = _recipeCards

    private val _favorites = MutableStateFlow<List<RecipeCard>>(emptyList())
    //val favorites: Flow<List<RecipeCard>> = _favorites.asStateFlow()
    val favorites: Flow<List<RecipeCard>> = favoritesDataSource
        .getFavorites()
        .map { recipeIds ->
            recipeIds.map { recipeId ->
                RecipeCard(recipeId = recipeId.recipeId, isFavorite = true)
            }
        }

   /* init {
        viewModelScope.launch(Dispatchers.IO) {
           //val favoritesRecipies =
             //   DependencyProvider.recipeRepo.fetchData("recipeId")  ////what is the pathhhhhhhhhhhhh
            favoritesDataSource
                .getFavorites()
                .collect { favorites ->
                    val favoritesRecipes =
                        DependencyProvider.recipeRepo.fetchData("recipeId")  // Replace "recipeId" with the actual recipeId
                    _favorites.value = favoritesRecipes.map { imageUrl ->
                        RecipeCard(
                            imageUrl = imageUrl,
                            isFavorite = favorites.contains(imageUrl)
                        )
                    }
                }
        }*/




        fun onFavoriteButtonClicked(recipeCard: RecipeCard) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    favoritesDataSource.toggleFavorite(recipeCard.imageUrl)
                    println("Toggled favorite for imageUrl:  ${recipeCard.imageUrl}")
                } catch (e: Exception) {
                    println("Error toggling favorite: ${e.message}")
                }
                favoritesDataSource.toggleFavorite(recipeCard.imageUrl)
            }
        }
    }


