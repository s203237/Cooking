package com.example.cooking.UI.RecipePage

import android.util.Log
import androidx.compose.runtime.rememberUpdatedState
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
            println("Printing just before calling dependency provider")
            val recipeData = DependencyProvider.recipeDataSource.fetchData("miso-butter-soup")
            _recipe.value = recipeData
        //val recipeInstance = getRecipeInstance(recipeData)
            //_recipe.value = recipeInstance
        }
    }

    fun getRecipeId() {

    }


}