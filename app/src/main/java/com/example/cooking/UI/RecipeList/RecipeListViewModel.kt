package com.example.cooking.UI.RecipeList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.util.Log
import com.example.cooking.data.remote.RecipeCard

class RecipeListViewModel: ViewModel() {

    private val _recipes = MutableStateFlow<List<RecipeCard>>(emptyList())
    val recipes = _recipes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            Log.v("Before", "Fetching recipe data string")
            val recipeCards = DependencyProvider.recipeCardDataSource.fetchData()
            val recipeList = com.example.cooking.data.remote.getRecipeCardInstances(recipeCards)
            _recipes.value = recipeList

        }
    }
}
