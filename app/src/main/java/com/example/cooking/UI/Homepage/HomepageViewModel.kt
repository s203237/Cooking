import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.HomepageCuration
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Calendar

class HomePageViewModel : ViewModel() {
    private val _recipeCollection1 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection2 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection3 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection4 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection5 = MutableStateFlow(RecipeCollection())
    private val _dailyRecipe = MutableStateFlow(RecipeCard())

    val recipeCollection1 = _recipeCollection1.asStateFlow()
    val recipeCollection2 = _recipeCollection2.asStateFlow()
    val recipeCollection3 = _recipeCollection3.asStateFlow()
    val recipeCollection4 = _recipeCollection4.asStateFlow()
    val recipeCollection5 = _recipeCollection5.asStateFlow()
    val dailyRecipe = _dailyRecipe.asStateFlow()

    private val favoritesDataSource = DependencyProvider.favoritesDataSource

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val collections = HomepageCuration().loadCollectionNames()
            _recipeCollection1.value = DependencyProvider.recipeCollectionRepo.fetchData(collections[0])
            _recipeCollection2.value = DependencyProvider.recipeCollectionRepo.fetchData(collections[1])
            _recipeCollection3.value = DependencyProvider.recipeCollectionRepo.fetchData(collections[2])
            _recipeCollection4.value = DependencyProvider.recipeCollectionRepo.fetchData(collections[3])
            _recipeCollection5.value = DependencyProvider.recipeCollectionRepo.fetchData(collections[4])

            _dailyRecipe.value = getDailyRecipe(_recipeCollection5.value)

            val favorites = favoritesDataSource.getFavorites().first()
            updateCollectionsWithFavorites(favorites)
        }
    }

    private fun updateCollectionsWithFavorites(favorites: List<String>) {
        Log.d("HomePageViewModel", "Updating favorites: $favorites")
        _recipeCollection1.value = updateFavoriteStatus(_recipeCollection1.value, favorites)
        Log.d("HomePageViewModel", "First recipe favorite status: ${_recipeCollection1.value.results.firstOrNull()?.isFavorite}")

        _recipeCollection2.value = updateFavoriteStatus(_recipeCollection2.value, favorites)
        Log.d("HomePageViewModel", "Second recipe favorite status: ${_recipeCollection2.value.results.firstOrNull()?.isFavorite}")

        _recipeCollection3.value = updateFavoriteStatus(_recipeCollection3.value, favorites)
        Log.d("HomePageViewModel", "3rd recipe favorite status: ${_recipeCollection3.value.results.firstOrNull()?.isFavorite}")

        _recipeCollection4.value = updateFavoriteStatus(_recipeCollection4.value, favorites)
        Log.d("HomePageViewModel", "4th recipe favorite status: ${_recipeCollection4.value.results.firstOrNull()?.isFavorite}")

        _recipeCollection5.value = updateFavoriteStatus(_recipeCollection5.value, favorites)
        Log.d("HomePageViewModel", "5th recipe favorite status: ${_recipeCollection5.value.results.firstOrNull()?.isFavorite}")

    }

    private fun updateFavoriteStatus(collection: RecipeCollection, favorites: List<String>): RecipeCollection {
        val updatedRecipes = collection.results.map { recipe ->
            recipe.copy(isFavorite = favorites.contains(recipe.recipeId))
        }
        return collection.copy(results = updatedRecipes)
    }

    fun onFavoriteButtonClicked(recipeId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            favoritesDataSource.toggleFavorite(recipeId)
            val updatedFavorites = favoritesDataSource.getFavorites().first()
            Log.d("HomePageViewModel", "Toggled favorite, updated list: $updatedFavorites")
            updateCollectionsWithFavorites(updatedFavorites)
        }
    }

    private fun getDailyRecipe(collection: RecipeCollection): RecipeCard {
        if (collection.results.isEmpty()) {
            return RecipeCard() // or handle appropriately
        }
        val calendar = Calendar.getInstance()
        val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
        val i = currentDate % collection.results.size
        return collection.results[i]
    }
}
