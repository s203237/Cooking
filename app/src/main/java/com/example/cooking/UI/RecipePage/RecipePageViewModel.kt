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

/**
 * The `RecipePageViewModel` class is a [ViewModel] responsible for managing and providing data
 * related to a specific recipe for display in the UI. It interacts with the
 * [DependencyProvider.recipeRepo] to fetch detailed recipe data based on the specified recipe ID.
 *
 * Properties:
 * - `_recipe`: A [MutableStateFlow] representing the current detailed recipe.
 * - `recipe`: A public [StateFlow] providing read-only access to the detailed recipe.
 * - `_recipeId`: A [MutableStateFlow] representing the current recipe ID.
 *
 * Functions:
 * - `updateRecipeId(newRecipeId: String)`: Updates the recipe ID and triggers the retrieval of
 *   detailed recipe data for the new ID.
 *
 * Initialization:
 * - In the [init] block, a [LaunchedEffect] is used to observe changes in the `_recipeId`
 *   state flow. When the recipe ID changes, the view model fetches the corresponding detailed
 *   recipe data using [DependencyProvider.recipeRepo] and updates the `_recipe` state flow.
 *
 * @see DependencyProvider
 */
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