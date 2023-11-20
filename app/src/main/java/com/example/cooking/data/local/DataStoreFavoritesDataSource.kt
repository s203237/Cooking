package com.example.cooking.data.local

import FavoriteDataSource
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DataStoreFavoritesDataSource(private val context: Context): FavoriteDataSource {

    private val Context.dataStore by preferencesDataStore("favorites")
    private val favoritesKey = stringPreferencesKey("favorites")

    override fun getFavorites(): Flow<List<String>> {
        return context.dataStore.data.map { prefs->
            val jsonString = prefs[favoritesKey].orEmpty()
            try {
                Json.decodeFromString(jsonString)
            }catch (error: Throwable){
                emptyList()
            }
        }
    }

    override suspend fun toggleFavorite(imageUrl: String) {
        val currentJsonString = context.dataStore.data.first()[favoritesKey].orEmpty()
        val currentFavorites: List<String> = try {
            Json.decodeFromString(currentJsonString)
        }catch (error: Throwable){
            emptyList()
        }
        val isfavorite = currentFavorites.contains(imageUrl)
        val updatedFavorites = if (isfavorite){
            currentFavorites - imageUrl
        } else{
            currentFavorites + imageUrl
        }
        val updatedJsonString = Json.encodeToString(updatedFavorites)
        context.dataStore.edit {
            it[favoritesKey] = updatedJsonString
        }
    }
}

