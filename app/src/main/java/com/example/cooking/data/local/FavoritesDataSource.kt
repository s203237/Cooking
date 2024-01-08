package com.example.cooking.data.local

import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.flow.Flow

interface FavoritesDataSource {
    fun getFavorites(): Flow<List<RecipeCard>>
    suspend fun toggleFavorite(recipeId: Int)
}