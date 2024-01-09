package com.example.cooking.UI.RecipeList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.remote.FetchParameters
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.createCardsFromDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
   // private val query = MutableStateFlow("")

    fun updateCollectionName(newCollectionName: String) {
        _collectionName.value = newCollectionName
    }

    fun getCardsByTags(tagsList: List<String>, cards: List<RecipeCard>): List<RecipeCard> {
        return cards.filter { card ->
            val names = card.tags.map{ it.name }
            val predicate: (String) -> Boolean = {it in tagsList}
            names.any(predicate)
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
              _collectionName.collect{newCollectionName ->
                val cardDtoList = DependencyProvider.recipeCollectionRepo.fetchData(
                    FetchParameters(
                        id = newCollectionName
                    )
                ).results
                Log.v("RecipeListViewModel", cardDtoList.toString())
                val recipeCards = createCardsFromDto(cardDtoList)
                _recipeCards.value = recipeCards
            }
        }
    }

}