package com.example.cooking.UI.RecipeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.remote.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeListViewModel: ViewModel() {

    private val _recipeCards = MutableStateFlow<List<RecipeCard>>(emptyList())
    val recipeCards = _recipeCards.asStateFlow()
    private val collectionName = "easy-vegetarian-recipes"
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeCards = DependencyProvider.recipeCardDataSource.fetchData(collectionName)
            //val recipeList = com.example.cooking.data.remote.getRecipeCardInstances(recipeCards)
            _recipeCards.value = recipeCards
            //_recipeCards.value = recipeList

        }
    }


}
