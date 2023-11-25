package com.example.cooking.UI.RecipeList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.UI.Homepage.RecipeCard
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

/**
 * The `RecipeListViewModel` class is a [ViewModel] responsible for managing and providing data
 * related to a list of recipe cards for display in the UI. It interacts with the
 * [DependencyProvider.recipeCardRepo] to fetch recipe card data based on the specified
 * collection name.
 *
 * Properties:
 * - `_recipeCards`: A [MutableStateFlow] representing the current list of recipe cards.
 * - `recipeCards`: A public [StateFlow] providing read-only access to the list of recipe cards.
 * - `_collectionName`: A [MutableStateFlow] representing the current collection name.
 *
 * Functions:
 * - `updateCollectionName(newCollectionName: String)`: Updates the collection name and triggers
 *   the retrieval of recipe cards for the new collection.
 *
 * Initialization:
 * - In the [init] block, a [LaunchedEffect] is used to observe changes in the `_collectionName`
 *   state flow. When the collection name changes, the view model fetches the corresponding recipe
 *   cards using [DependencyProvider.recipeCardRepo] and updates the `_recipeCards` state flow.
 * @see DependencyProvider
 */
class RecipeListViewModel: ViewModel() {

    private val _recipeCards = MutableStateFlow<List<RecipeCard>>(emptyList())
    val recipeCards = _recipeCards.asStateFlow()
    private val _collectionName = MutableStateFlow("")

    private val favoritesDataSource = DependencyProvider.favoritesDataSource

    fun updateCollectionName(newCollectionName: String) {
        _collectionName.value = newCollectionName
        val printOutValue = _collectionName.value
        Log.v("CollectionName Trace", "In updateCollectionName: $printOutValue")

    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            //val recipies = DependencyProvider.recipeCardRepo.fetchData()
            _collectionName.collect{newCollectionName ->
                Log.v("CollectionName Trace", "CollectionName in viewModel.launch: $newCollectionName")
                val recipeCards = DependencyProvider.recipeCardRepo.fetchData(_collectionName.value)
                //val favorites = favoritesDataSource.getFavorites().first()
                _recipeCards.value = recipeCards
               favoritesDataSource
                    .getFavorites()
                    .collect{ favorites ->
                        _recipeCards.value = recipeCards.map{ recipeCard ->
                            RecipeCard(
                                imageUrl = recipeCard.imageUrl,
                                isFavorite = favorites.contains(recipeCard.imageUrl)
                            )
                        }

                    }
            }

        }
    }




}
