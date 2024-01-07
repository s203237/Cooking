package com.example.cooking.UI.Homepage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.remote.CollectionDto
import com.example.cooking.data.remote.FetchParameters
import com.example.cooking.model.ListType
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.RecipeCollection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import kotlin.random.Random

class HomePageViewModel: ViewModel() {
    private val collections = HomepageCuration().loadCollectionData()
    //private val collections = HomepageCuration().loadCollectionNames()
    val size = HomepageCuration().getCollectionsCount()

    private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList())
    val recipeCollections = _recipeCollections.asStateFlow()

    private val _dailyRecipe = MutableStateFlow(RecipeCard())
    val dailyRecipe = _dailyRecipe.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeCollections : List<CollectionDto> = collections.map{
                val parameters = FetchParameters(
                    id = it.id,
                    size = it.size
                )
                DependencyProvider.recipeCollectionRepo.fetchData(parameters)
            }

            //val listTypes = HomepageCuration().loadListTypes()

            _recipeCollections.value = recipeCollections.mapIndexed { index, collection ->
                val results = when(collections[index].listType) {
                    ListType.CARD -> {
                        Log.v("Homepage VM Coll results", collection.results.toString())
                        listOf(getRandomRecipeCard(collection))
                    }
                    else -> {
                        collection.results.map { card ->
                            RecipeCard(card.recipeId, card.title, card.imageUrl)
                        }
                    }
                }

                RecipeCollection(collections[index].id, results, collections[index].listType)

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

fun getRandomRecipeCard(collection: CollectionDto): RecipeCard {
    val size = collection.results.size
    val i = Random.nextInt(0, size)
    val card = collection.results[i]
    return RecipeCard(card.recipeId, card.title, card.imageUrl)
}

