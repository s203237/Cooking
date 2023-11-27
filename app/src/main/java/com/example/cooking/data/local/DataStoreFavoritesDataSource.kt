package com.example.cooking.data.local

import FavoritesDataSource
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DataStoreFavoritesDataSource(private val context: Context): FavoritesDataSource {

    private val Context.dataStore by preferencesDataStore("Favorites")
    private val favoritesKey = stringPreferencesKey("Favorites")

    override fun getFavorites(): Flow<List<RecipeCard>> {
        return context.dataStore.data.map { prefs->
            val jsonString = prefs[favoritesKey].orEmpty()
            try {
                Json.decodeFromString(jsonString)
            }catch (error: Throwable){
                emptyList()
            }
        }
    }

    override suspend fun toggleFavorite(recipieId: String) {
        val currentJsonString = context.dataStore.data.first()[favoritesKey].orEmpty()
        val currentFavorites: List<String> = try {
            Json.decodeFromString(currentJsonString)
        }catch (error: Throwable){
            emptyList()
        }
        val isfavorite = currentFavorites.contains(recipieId)
        val updatedFavorites = if (isfavorite){
            currentFavorites - recipieId
        } else{
            currentFavorites + recipieId
        }
        val updatedJsonString = Json.encodeToString(updatedFavorites)
        context.dataStore.edit {
            it[favoritesKey] = updatedJsonString
        }
    }
}