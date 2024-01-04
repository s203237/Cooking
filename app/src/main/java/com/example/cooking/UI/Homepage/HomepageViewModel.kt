package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

class HomePageViewModel: ViewModel() {
    private val collections = HomepageCuration().loadCollectionNames()

    val size = HomepageCuration().getCollectionsCount()
    private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList())
    val recipeCollections = _recipeCollections.asStateFlow()

    private val _dailyRecipe = MutableStateFlow(RecipeCard())

    val dailyRecipe = _dailyRecipe.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeCollections : List<RecipeCollection> = collections.map{
                DependencyProvider.recipeCollectionRepo.fetchData(it)
            }

            val listTypes = HomepageCuration().loadListTypes()

            listTypes.mapIndexed { index, type ->
                recipeCollections[index].type = type
            }

            _recipeCollections.value = recipeCollections
            _dailyRecipe.value = getDailyRecipe(recipeCollections[size-1])
        }
    }
}

fun getDailyRecipe(collection : RecipeCollection) : RecipeCard {
    val calendar = Calendar.getInstance()
    val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
    val i = currentDate % collection.results.size
    return collection.results[i]
}