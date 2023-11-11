package com.example.cooking.UI.RecipePage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipePageViewModel: ViewModel() {
    private val _recipe = MutableStateFlow(Recipe())
    val recipe = _recipe.asStateFlow()

    private val _recipeId = MutableStateFlow("")
    fun updateRecipeId(newRecipeId: String) {
        _recipeId.value = newRecipeId
        val printoutValue = _recipeId.value
        Log.v("RecipeId Trace","RecipeId in viewModel.updateRecipeId: $printoutValue")
    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            _recipeId.collect { newRecipeId ->
                Log.v("RecipeId Trace", "RecipeId in viewModel.launch: $newRecipeId")
                val recipeData = DependencyProvider.recipeRepo.fetchData(_recipeId.value)
                _recipe.value = recipeData
            }
        }
    }

}