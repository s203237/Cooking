
import kotlinx.coroutines.flow.Flow

interface FavoriteDataSource {
    fun getFavorites(): Flow<List<String>>
    suspend fun toggleFavorite(imageUrl: String)
}