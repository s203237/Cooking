package com.example.cooking.UI.RecipePage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.remote.getRecipeInstance
import com.example.cooking.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipePageViewModel: ViewModel() {
    private val _recipe = MutableStateFlow(Recipe())
    val recipe = _recipe.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeData = DependencyProvider.recipeDataSource.fetchData().joinToString()
            Log.v("PrintString", recipeData)
            val recipeInstance = getRecipeInstance(recipeData)
            _recipe.value = recipeInstance
        }
    }
}