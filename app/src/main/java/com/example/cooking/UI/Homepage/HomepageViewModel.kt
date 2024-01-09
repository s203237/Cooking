package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.remote.CollectionDto
import com.example.cooking.data.remote.FetchParameters
import com.example.cooking.data.remote.HomepageCollection
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import com.example.cooking.model.createCardsFromDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

class HomePageViewModel: ViewModel() {
    private val collectionData = HomepageCuration().loadCollectionData()
    //private val collections = HomepageCuration().loadCollectionNames()
    val size = HomepageCuration().getCollectionsCount()

    private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList())
    val recipeCollections = _recipeCollections.asStateFlow()

    private val _dailyRecipe = MutableStateFlow(RecipeCard())
    val dailyRecipe = _dailyRecipe.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val collectionDtoList : List<CollectionDto> = collectionData.map{
                val parameters = FetchParameters(
                    id = it.id,
                    size = it.size
                )
                DependencyProvider.recipeCollectionRepo.fetchData(parameters)
            }

            _recipeCollections.value = collectionDtoList.mapIndexed { index, collection ->
                createRecipeCollection(collection, collectionData[index])
            }
            _dailyRecipe.value = getDailyRecipe(_recipeCollections.value[size-1])
        }
    }
}

fun getDailyRecipe(collection : RecipeCollection) : RecipeCard {
    val calendar = Calendar.getInstance()
    val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
    val i = currentDate % collection.results.size
    return collection.results[i]
}

fun createRecipeCollection(dto: CollectionDto, collectionData: HomepageCollection) : RecipeCollection {
    val results = createCardsFromDto(dto.results)
    return RecipeCollection(collectionData.id, results, collectionData.listType)
}

