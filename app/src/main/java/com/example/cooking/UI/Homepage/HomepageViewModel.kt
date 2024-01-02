package com.example.cooking.UI.Homepage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.HomepageCuration
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

    /*private val _recipeCollection1 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection2 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection3 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection4 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection5 = MutableStateFlow(RecipeCollection())
    */
    private val _dailyRecipe = MutableStateFlow(RecipeCard())

    /*
    val recipeCollection1 = _recipeCollection1.asStateFlow()
    val recipeCollection2 = _recipeCollection2.asStateFlow()
    val recipeCollection3 = _recipeCollection3.asStateFlow()
    val recipeCollection4 = _recipeCollection4.asStateFlow()
    val recipeCollection5 = _recipeCollection5.asStateFlow()*/

    val dailyRecipe = _dailyRecipe.asStateFlow()
    //private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList<RecipeCollection>())
    //val recipeCollections = _recipeCollections.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            Log.v("Homepage size _recipeCollections", _recipeCollections.value.size.toString())
            Log.v("Homepage size recipeCollections", recipeCollections.value.size.toString())

            val recipeCollections = mutableListOf<RecipeCollection>()
            Log.v("Homepage coll size before fetch", recipeCollections.size.toString())

            for (collectionName in collections) {
                val collection = DependencyProvider.recipeCollectionRepo.fetchData(collectionName)
                recipeCollections.add(collection)
                Log.v("Homepage in forloop", recipeCollections[0].collectionName)

            }

            Log.v("Homepage coll size after fetch", recipeCollections.size.toString())

            /*collections.forEach {
                DependencyProvider.recipeCollectionRepo.fetchData(it)

            }
            val recipeCollections : List<RecipeCollection> = collections.map{
                DependencyProvider.recipeCollectionRepo.fetchData(it)
            }*/

            Log.v("HomepageVM", recipeCollections[0].collectionName)


            _recipeCollections.value = recipeCollections
            /*val recipeCollection1 = DependencyProvider.recipeCollectionRepo.fetchData(collections[0])
            val recipeCollection2 = DependencyProvider.recipeCollectionRepo.fetchData(collections[1])
            val recipeCollection3 = DependencyProvider.recipeCollectionRepo.fetchData(collections[2])
            val recipeCollection4 = DependencyProvider.recipeCollectionRepo.fetchData(collections[3])
            val recipeCollection5 = DependencyProvider.recipeCollectionRepo.fetchData(collections[4])
*/
            _dailyRecipe.value = getDailyRecipe(recipeCollections[size-1])
/*
            _recipeCollection1.value = recipeCollection1
            _recipeCollection2.value = recipeCollection2
            _recipeCollection3.value = recipeCollection3
            _recipeCollection4.value = recipeCollection4
            _recipeCollection5.value = recipeCollection5
*/
        }
    }
}

fun getDailyRecipe(collection : RecipeCollection) : RecipeCard {
    val calendar = Calendar.getInstance()
    val currentDate = calendar.get(Calendar.DAY_OF_MONTH)
    val i = currentDate % collection.results.size
    return collection.results[i]
}