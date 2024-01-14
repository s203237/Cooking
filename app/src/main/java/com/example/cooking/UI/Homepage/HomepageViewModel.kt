package com.example.cooking.UI.Homepage

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



            /*_recipeCollections.value = collectionDtoList.mapIndexed { index, collection ->
                createRecipeCollection(collection, collectionData[index])
            }*/

//
  /*          val favoritesCards = favoritesDataSource.getFavorites().first()
            val favoriteIds = favoritesCards.map { it } // Assuming 'id' is the property that holds the recipe ID
            updateCollectionsWithFavorites(favoriteIds)
*/
        }
    }
  /*  private fun updateCollectionsWithFavorites(favorites: List<RecipeCard>) {
        _recipeCollections.value = _recipeCollections.value.map { collection ->
            collection.copy(results = collection.results.map { recipe ->
                recipe.copy(isFavorite = favorites.any { it.id == recipe.id })
            })
        }
    }


    private fun updateFavoriteStatus(collection: RecipeCollection, favorites: List<RecipeCard>): RecipeCollection {
        val updatedRecipes = collection.results.map { recipe ->
            recipe.copy(isFavorite = favorites.contains(recipe))
        }
        return collection.copy(results = updatedRecipes)
    }
*/
    /*fun onFavoriteButtonClicked(recipeCard: RecipeCard) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                favoritesDataSource.toggleFavorite(recipeCard)
                println("Favorite toggled for image URL: $recipeCard")
                //val updatedFavorites = favoritesDataSource.getFavorites().first()
                //updateCollectionsWithFavorites(updatedFavorites)


            } catch (e: Exception) {
                println("Error toggling favorite: $e")
            }
        }
    }
    fun onFavoriteButtonClicked(recipeCard: RecipeCard) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                favoritesDataSource.toggleFavorite(recipeCard)
                val updatedCollections = _recipeCollections.value.map { collection ->
                    val updatedRecipes = collection.results.map { recipe ->
                        if (recipe.id == recipeCard.id) {
                            recipe.copy(isFavorite = !recipe.isFavorite)
                        } else {
                            recipe
                        }
                    }
                    collection.copy(results = updatedRecipes)
                }
                _recipeCollections.value = updatedCollections

                // Update the dailyRecipe if it's the one being favorited
                if (_dailyRecipe.value.id == recipeCard.id) {
                    val updatedDailyRecipe = _dailyRecipe.value.copy(isFavorite = !recipeCard.isFavorite)
                    _dailyRecipe.value = updatedDailyRecipe
                }
            } catch (e: Exception) {
                println("Error toggling favorite: $e")
            }


        }
    }

}
*/
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

