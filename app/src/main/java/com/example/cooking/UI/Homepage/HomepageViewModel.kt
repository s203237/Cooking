package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.Calendar

class HomePageViewModel : ViewModel() {
    private val collections = HomepageCuration().loadCollectionNames()

    private val count = HomepageCuration().getCollectionsCount()
    private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList())
    val recipeCollections = _recipeCollections.asStateFlow()

    private val _dailyRecipe = MutableStateFlow(RecipeCard())

    val dailyRecipe = _dailyRecipe.asStateFlow()
    private val favoritesDataSource = DependencyProvider.favoritesDataSource

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeCollections: List<RecipeCollection> = collections.map {
                DependencyProvider.recipeCollectionRepo.fetchData(it)
            }

            val listTypes = HomepageCuration().loadListTypes()

            listTypes.mapIndexed { index, type ->
                // Log.v("HP Viewmodel", recipeCollections[index].collectionName)
                recipeCollections[index].type = type
            }

            _recipeCollections.value = recipeCollections
            //Log.v("HP Viewmodel", "collections size $count")
            _dailyRecipe.value = getDailyRecipe(recipeCollections[count - 1])

//            val recipeCards1 = DependencyProvider.recipeCardRepo.fetchData("tofu")
//            val recipeCards2 = DependencyProvider.newrecipeCardRepo.fetchData("carrot")
//            val recipeCards3 = DependencyProvider.newrecipeCardRepo.fetchData("pasta")
//            val recipeCards4 = DependencyProvider.newrecipeCardRepo.fetchData("salad")

            //_dailyRecipe.value = dailyRecipe
//            _recipeCards1.value = recipeCards1
//            _recipeCards2.value = recipeCards1
//            _recipeCards3.value = recipeCards1
//            _recipeCards4.value = recipeCards1

//            _recipeCards2.value = recipeCards2
//            _recipeCards3.value = recipeCards3
//            _recipeCards4.value = recipeCards4
            val favoritesCards = favoritesDataSource.getFavorites().first()
            val favoriteIds = favoritesCards.map { it } // Assuming 'id' is the property that holds the recipe ID
            updateCollectionsWithFavorites(favoriteIds)

        }
    }
    private fun updateCollectionsWithFavorites(favorites: List<RecipeCard>) {
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
    }*/
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

fun getDailyRecipe(collection: RecipeCollection): RecipeCard {
    if (collection.results.isEmpty()) {
        return RecipeCard()
    }
    val calendar = Calendar.getInstance()
    val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
    val i = currentDate % collection.results.size
    return collection.results[i]
}