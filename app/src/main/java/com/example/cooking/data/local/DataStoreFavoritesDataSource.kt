package com.example.cooking.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class DataStoreFavoritesDataSource(private val context: Context) : FavoritesDataSource {
    private val Context.dataStore by preferencesDataStore("favorites")
    private val favoritesKey = stringPreferencesKey("favorites")


    override fun getFavorites(): Flow<List<RecipeCard>> {
        return context.dataStore.data.map { prefs ->
            val jsonString = prefs[favoritesKey].orEmpty()
            try {
                Json.decodeFromString(jsonString)
            } catch (error: Throwable) {
                emptyList<RecipeCard>()
            }
        }
    }

   override suspend fun toggleFavorite(recipeCard: RecipeCard) {
       val currentJsonString = context.dataStore.data.first()[favoritesKey].orEmpty()
       val currentFavorites: List<RecipeCard> = try {
           Json.decodeFromString(currentJsonString)
       } catch (error: Throwable) {
           emptyList()
       }

       // Determine if the recipeCard is already a favorite
       val isFavorite = currentFavorites.any { it.id == recipeCard.id }

       // Update the list of favorites
       val updatedFavorites = if (isFavorite) {
           // Remove the recipeCard by filtering out the matching ID
           currentFavorites.filter { it.id != recipeCard.id }
       } else {
           // Add the recipeCard and ensure 'isFavorite' is set to true
           currentFavorites + recipeCard.copy(isFavorite = true)
       }

       // Serialize the updated list back to a JSON string
       val updatedJsonString = Json.encodeToString(updatedFavorites)
       context.dataStore.edit {
           it[favoritesKey] = updatedJsonString
       }
       Log.d("DataStoreFavoritesDataSource", "Updated Favorites: $updatedFavorites")
   }

}
