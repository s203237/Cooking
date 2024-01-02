package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.DependencyProvider.favoritesDataSource
import com.example.cooking.data.HomepageCuration
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

class HomePageViewModel: ViewModel() {
    private val collections = HomepageCuration().loadCollectionNames()
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
    //private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList<RecipeCollection>())
    //val recipeCollections = _recipeCollections.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeCollection1 = DependencyProvider.recipeCollectionRepo.fetchData(collections[0])
            val recipeCollection2 = DependencyProvider.recipeCollectionRepo.fetchData(collections[1])
            val recipeCollection3 = DependencyProvider.recipeCollectionRepo.fetchData(collections[2])
            val recipeCollection4 = DependencyProvider.recipeCollectionRepo.fetchData(collections[3])
            val recipeCollection5 = DependencyProvider.recipeCollectionRepo.fetchData(collections[4])

            _dailyRecipe.value = getDailyRecipe(recipeCollection5)

            _recipeCollection1.value = recipeCollection1
            _recipeCollection2.value = recipeCollection2
            _recipeCollection3.value = recipeCollection3
            _recipeCollection4.value = recipeCollection4
            _recipeCollection5.value = recipeCollection5

        }
    }
    fun onFavoriteButtonClicked(imageUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                favoritesDataSource.toggleFavorite(imageUrl)
                println("Favorite toggled for image URL: $imageUrl")
            } catch (e: Exception) {
                println("Error toggling favorite: $e")
            }
        }
    }
}

fun getDailyRecipe(collection : RecipeCollection) : RecipeCard {
    val calendar = Calendar.getInstance()
    val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
    val i = currentDate % collection.results.size
    return collection.results[i]
}