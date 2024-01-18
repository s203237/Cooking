package com.example.cooking.UI.Homepage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.remote.CollectionDto
import com.example.cooking.data.remote.FetchParameters
import com.example.cooking.data.remote.HomepageCollection
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import com.example.cooking.model.createCardsFromDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

class HomePageViewModel: ViewModel() {
    private val collectionData = HomepageCuration().loadCollectionData()
    //private val collections = HomepageCuration().loadCollectionNames()
    val size = HomepageCuration().getCollectionsCount()

    private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList())
    val recipeCollections = _recipeCollections.asStateFlow()

    private val _dailyRecipe = MutableStateFlow(RecipeCard())

    val dailyRecipe = _dailyRecipe.asStateFlow()

    private val favoritesDataSource = DependencyProvider.favoritesDataSource

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val collectionDtoList : List<CollectionDto> = collectionData.map{
                val parameters = FetchParameters(
                    id = it.id,
                    size = it.size
                )
                DependencyProvider.recipeCollectionRepo.fetchData(parameters)
            }

            val recipeCollections = collectionDtoList.mapIndexed { index, collection ->
                createRecipeCollection(collection, collectionData[index])
            }

            favoritesDataSource
                .getFavorites()
                .collect { favorites ->
                    _recipeCollections.value = recipeCollections.map { collection ->
                        RecipeCollection(
                            collectionName = collection.collectionName,
                            results = collection.results.map { card ->
                                RecipeCard(
                                    id = card.id,
                                    name = card.name,
                                    thumbnail_url = card.thumbnail_url,
                                    tags = card.tags,
                                    isFavorite = favorites.any { it.id == card.id }
                                )
                            },
                            type = collection.type
                        )
                    }
                    val dailyRecipe = getDailyRecipe(_recipeCollections.value[size - 1])

                        _dailyRecipe.value = RecipeCard(
                            id = dailyRecipe.id,
                            name = dailyRecipe.name,
                            thumbnail_url = dailyRecipe.thumbnail_url,
                            tags = dailyRecipe.tags,
                            isFavorite = favorites.any { it.id == dailyRecipe.id }
                        )
                    }
                }
    }
    fun onFavoriteButtonClicked(recipeCard: RecipeCard) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                DependencyProvider.favoritesDataSource.toggleFavorite(recipeCard)
                // refreshFavorites() // Refresh the favorites list after toggling the status
            } catch (e: Exception) {
                Log.e("FavoritesScreenViewModel", "Error toggling favorite: $e")
            }
        }
    }
}

fun getDailyRecipe(collection : RecipeCollection) : RecipeCard {
    val calendar = Calendar.getInstance()
    val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
    val i = currentDate % collection.results.size
    return RecipeCard(
        id = collection.results[i].id,
        name = collection.results[i].name,
        thumbnail_url = collection.results[i].thumbnail_url,
        tags = collection.results[i].tags,
        isFavorite = collection.results[i].isFavorite
    )
}

fun createRecipeCollection(dto: CollectionDto, collectionData: HomepageCollection) : RecipeCollection {
    val results = createCardsFromDto(dto.results)
    return RecipeCollection(collectionData.id, results, collectionData.listType)
}

