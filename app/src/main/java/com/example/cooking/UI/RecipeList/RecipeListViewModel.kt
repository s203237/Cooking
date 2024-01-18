package com.example.cooking.UI.RecipeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.DependencyProvider.favoritesDataSource
import com.example.cooking.data.remote.FetchParameters
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.createCardsFromDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.dropWhile
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
    private val _collectionName = MutableStateFlow("")

    private val _recipeCards = MutableStateFlow<List<RecipeCard>>(emptyList())
    val recipeCards = _recipeCards.asStateFlow()

    private val _noResults = MutableStateFlow(false)
    val noResults = _noResults.asStateFlow()

    private val _unfilteredRecipeCards = MutableStateFlow<List<RecipeCard>>(emptyList())

    /* private val _filters = MutableStateFlow<Set<String>>(emptySet())
     val filters = _filters.asStateFlow()*/
    private val filters = mutableSetOf<String>()

    private val _buttonStates = MutableStateFlow((1..getFiltersList().size).associateWith { false })
    val buttonStates = _buttonStates.asStateFlow()

    private val _buttonId = MutableStateFlow(0)

    //private val buttonStates = mutableMapOf<Int,Boolean>()
    /*private val _isSelected = MutableStateFlow<Boolean>(false)
    val isSelected = _isSelected.asStateFlow()*/
    fun updateCollectionName(newCollectionName: String) {
        _collectionName.value = newCollectionName
    }

    fun toggleFilter(isSelected: Boolean, tag: String) {
        if(isSelected) {
            addToFilters(tag)
        } else {
            removeFromFilters(tag)
        }

    }

    private fun addToFilters(tag: String) {
        filters += tag
    }

    private fun removeFromFilters(tag: String) {
        filters -= tag
    }

    fun setCardsByTags() {
        if (_unfilteredRecipeCards.value.isEmpty())
            _unfilteredRecipeCards.value = recipeCards.value

        val filteredRecipeCards = filterByTags(filters, _unfilteredRecipeCards.value)
        println(filteredRecipeCards.toString())
        _recipeCards.value = filteredRecipeCards
    }

    private fun filterByTags(tagsList: Set<String>, cards: List<RecipeCard>): List<RecipeCard> {
        return cards.filter { card ->
            val cardTagNames = card.tags.map{ it.name }
            val intersection = tagsList.intersect(cardTagNames.toSet())
            intersection == tagsList
        }
    }

    fun resetCardsList(){
        filters.clear()
        _recipeCards.value = _unfilteredRecipeCards.value
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _collectionName.dropWhile { it.isEmpty() }.collect{newCollectionName ->
                val cardDtoList = DependencyProvider.recipeCollectionRepo.fetchData(
                    FetchParameters(
                        id = newCollectionName
                    )
                ).results
                val recipeCards = createCardsFromDto(cardDtoList)
                _noResults.value = recipeCards.isEmpty()
                favoritesDataSource
                    .getFavorites()
                    .collect { favorites ->
                        val cardListForFavMapping = _recipeCards.value.ifEmpty { recipeCards }
                        _recipeCards.value = cardListForFavMapping.map { card ->
                            RecipeCard(
                                id = card.id,
                                name = card.name,
                                thumbnail_url = card.thumbnail_url,
                                tags = card.tags,
                                isFavorite = favorites.any { it.id == card.id }
                            )
                        }
                    }
            }

        }

    }

}