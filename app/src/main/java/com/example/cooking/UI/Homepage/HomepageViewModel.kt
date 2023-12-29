package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.RecipeCollection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomePageViewModel: ViewModel() {
    //private val collections = HomepageCuration().loadCollectionNames()
    private val _recipeCollection1 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection2 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection3 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection4 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection5 = MutableStateFlow(RecipeCollection())

    private val collections = listOf (
        "party",
        "party",
        "party",
        "party",
        "party"
    )

    val recipeCollection1 = _recipeCollection1.asStateFlow()
    val recipeCollection2 = _recipeCollection2.asStateFlow()
    val recipeCollection3 = _recipeCollection3.asStateFlow()
    val recipeCollection4 = _recipeCollection4.asStateFlow()
    val recipeCollection5 = _recipeCollection5.asStateFlow()
    //private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList<RecipeCollection>())
    //val recipeCollections = _recipeCollections.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeCollection1 = DependencyProvider.recipeCollectionRepo.fetchData("party")
            val recipeCollection2 = DependencyProvider.recipeCollectionRepo.fetchData("party")
            val recipeCollection3 = DependencyProvider.recipeCollectionRepo.fetchData("party")
            val recipeCollection4 = DependencyProvider.recipeCollectionRepo.fetchData("party")
            val recipeCollection5 = DependencyProvider.recipeCollectionRepo.fetchData("party")

            _recipeCollection1.value = recipeCollection1
            _recipeCollection2.value = recipeCollection2
            _recipeCollection3.value = recipeCollection3
            _recipeCollection4.value = recipeCollection4
            _recipeCollection5.value = recipeCollection5

/*
            Log.v("HomescreenVM", "before recipeCOllections creation")
            collections.forEach {

                Log.v("HomescreenVM", "coll name: $it")
            }
            val recipeCollections : List<RecipeCollection> = collections.map{
                RecipeCollection(it)
            }
            /*recipeCollections.forEach {
                Log.v("HomescreenVM", it.collectionName)
            }*/
            Log.v("HomescreenVM", "after recipeCOllections creation")
            //_recipeCollections.value = recipeCollections

 */
        }


    }

}