package com.example.cooking.data.local

import kotlinx.coroutines.flow.Flow

interface FavoritesDataSource {
    fun getFavorites(): Flow<List<String>>
    suspend fun toggleFavorite(recipeId: String)
}