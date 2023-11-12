package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.remote.RecipeCard
import com.example.cooking.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomePageViewModel: ViewModel() {
    //private val _dailyRecipe = MutableStateFlow(Recipe())
    //private val _dailyRecipe = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards = MutableStateFlow<List<RecipeCard>>(emptyList())
    //private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())

    val recipeCards = _recipeCards.asStateFlow()
    //val dailyRecipe = _dailyRecipe.asStateFlow()
    //val recipes = _recipes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //val dailyRecipeData = DependencyProvider.recipeDataSource.fetchData("miso-butternut-soup")
            //val dailyRecipeData = DependencyProvider.recipeCardDataSource.fetchData("breakfast-recipes")
            val recipeCards = DependencyProvider.recipeCardDataSource.fetchData("breakfast-recipes")
            //val recipes = DependencyProvider.recipeCardDataSource.fetchData("breakfast-recipes")

            //_dailyRecipe.value = dailyRecipeData
            _recipeCards.value = recipeCards
        }
    }
}

