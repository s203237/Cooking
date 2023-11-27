package dk.shape.dtu.networkrequestsandlocalstorage.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cooking.data.local.FavoritesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class DataStoreFavoritesDataSource(private val context: Context) : FavoritesDataSource {

    private val Context.dataStore by preferencesDataStore("favorites")

    private val favoritesKey = stringPreferencesKey("favorites")

    override fun getFavorites(): Flow<List<String>> {
        return context.dataStore.data.map {  prefs ->
            val jsonString = prefs[favoritesKey].orEmpty()
            try {
                Json.decodeFromString<List<String>>(jsonString)
            } catch (error: Throwable) {
                emptyList()
            }
        }
    }

    override suspend fun toggleFavorite(imageUrl: String) {
        val currentJsonString = context.dataStore.data.first()[favoritesKey].orEmpty()
        val currentFavorites: List<String> = try {
            Json.decodeFromString(currentJsonString)
        } catch (error: Throwable) {
            emptyList()
        }

        val isFavorite = currentFavorites.contains(imageUrl)
        val updatedFavorites = if (isFavorite) {
            currentFavorites - imageUrl
        } else {
            currentFavorites + imageUrl
        }

        val updatedJsonString = Json.encodeToString(updatedFavorites)
        context.dataStore.edit {
            it[favoritesKey] = updatedJsonString
        }

        Log.d("FavoritesScreenViewModel", "Updated Favorites: $updatedFavorites")
    }
}