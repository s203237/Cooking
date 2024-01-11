package dk.shape.dtu.networkrequestsandlocalstorage.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.cooking.data.local.FavoritesDataSource
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


/*class DataStoreFavoritesDataSource(
    private val context: Context,
    private val recipeCardRepo: RecipeDataRepo<RecipeCard>
) : FavoritesDataSource {

    private val Context.dataStore by preferencesDataStore("favorites")

    private val favoritesKey = stringPreferencesKey("favorites")

    override fun getFavorites(): Flow<List<RecipeCard>> {
        return context.dataStore.data.map {  prefs ->
            Log.d("FavoritesDataSource", "Fetching favorites data")

            val jsonString = prefs[favoritesKey].orEmpty()
            Log.d("FavoritesDataSource", "Current favorites JSON: $jsonString")
            val favoriteIds = try {
                Json.decodeFromString<List<Int>>(jsonString)
            } catch (error: Throwable) {
                emptyList<Int>()
            }
            // Fetch RecipeCard for each ID
            favoriteIds.mapNotNull { id ->
                try {
                    recipeCardRepo.fetchData(id.toString()) // Use RecipeCardRepo to fetch the RecipeCard
                } catch (e: Exception) {
                    println("Error fetching RecipeCard: ${e.message}")
                    null
                }
            }
            /*try {
                Json.decodeFromString(jsonString)

            } catch (error: Throwable) {
                emptyList()
            }*/

        }
    }

    override suspend fun toggleFavorite(recipeId: Int) {
        Log.d("Favorites", "Toggling favorite for recipeId: $recipeId")
        val currentJsonString = context.dataStore.data.first()[favoritesKey].orEmpty()
        Log.d("Favorites", "Current favorites JSON: $currentJsonString")
        val currentFavorites: List<Int> = try {
            Json.decodeFromString<List<Int>>(currentJsonString).also {
                Log.d("Favorites", "Decoded favorites: $it")
            }

        } catch (error: Throwable) {
            Log.e("Favorites", "Error decoding favorites: ${error.message}")
            emptyList()
        }


        val isFavorite = currentFavorites.contains(recipeId)
        Log.d("Favorites", "Is recipe favorite: $isFavorite")
        val updatedFavorites = if (isFavorite) {
            currentFavorites - recipeId
        } else {
            currentFavorites + recipeId
        }
        Log.d("Favorites", "Updated favorites: $updatedFavorites")
        val updatedJsonString = Json.encodeToString(updatedFavorites)
        context.dataStore.edit {
            it[favoritesKey] = updatedJsonString
        }

        Log.d("FavoritesScreenViewModel", "Updated Favorites: $updatedFavorites")
    }
}*/
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

       // val recipeIdString = recipeId.toString()
        val isFavorite = currentFavorites.contains(recipeCard)
        val updatedFavorites = if (isFavorite) {
            //currentFavorites - recipeCard
            currentFavorites.filter { it.id != recipeCard.id }
            //currentFavorites - recipeCard
        } else {
            currentFavorites + recipeCard
        }

        val updatedJsonString = Json.encodeToString(updatedFavorites)
        context.dataStore.edit {
            it[favoritesKey] = updatedJsonString
        }
        Log.d("DataStoreFavoritesDataSource", "Updated Favorites: $updatedFavorites")
    }
    suspend fun clearFavorites() {
        context.dataStore.edit { settings ->
            settings.clear()
        }
    }
}
