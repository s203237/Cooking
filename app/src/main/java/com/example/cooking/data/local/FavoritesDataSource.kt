
import kotlinx.coroutines.flow.Flow

interface FavoritesDataSource {
    fun getFavorites(): Flow<List<String>>
    suspend fun toggleFavorite(imageUrl: String)
}