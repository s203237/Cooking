package com.example.cooking.UI.Homepage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.HomepageCuration
import com.example.cooking.model.RecipeCollection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomePageViewModel: ViewModel() {

    //private val _dailyRecipe = MutableStateFlow(RecipeCard())
    private val collections = HomepageCuration().loadCollectionNames()
    private val _recipeCollections = MutableStateFlow<List<RecipeCollection>>(emptyList<RecipeCollection>())
    private val _recipeCollection1 = MutableStateFlow(RecipeCollection())
    private val _recipeCollection2 = MutableStateFlow(RecipeCollection())

    val recipeCollection1 = _recipeCollection1.asStateFlow()
    val recipeCollection2 = _recipeCollection2.asStateFlow()

    val recipeCollections = _recipeCollections.asStateFlow()

    //val dailyRecipe = _dailyRecipe.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val recipeCollection1 = DependencyProvider.recipeCollectionRepo.fetchData("vegetarian-pasta-recipes")
            val recipeCollection2 = DependencyProvider.recipeCollectionRepo.fetchData("vegan-slow-cooker-recipes")

            _recipeCollection1.value = recipeCollection1
            _recipeCollection2.value = recipeCollection2

            Log.v("HomePageViewModel", _recipeCollection1.value.collectionName)

            //val dailyRecipe = DependencyProvider.recipeSingleCardRepo.fetchData("miso-butternut-soup")


            /*
            val recipeCollections : List<RecipeCollection> = collections.map{
                DependencyProvider.recipeCollectionRepo.fetchData(it)
            }

            _recipeCollections.value = recipeCollections
            for(collection in _recipeCollections.value){
                val name = collection.collectionName
                Log.v("HomePageViewModel", "collectionName: $name")
            }*/
            /*val recipeCollections: List<RecipeCollection> = List(size = collections.size)
            for(i in collections.indices) {
                recipeCollections[i] = DependencyProvider.recipeCollectionRepo.fetchData(collections[i])

            }
            val recipeCards1 = DependencyProvider.recipeCardRepo.fetchData("high-protein-vegan-recipes")
            val recipeCards2 = DependencyProvider.recipeCardRepo.fetchData("vegan-winter-recipes")
            val recipeCards3 = DependencyProvider.recipeCardRepo.fetchData("vegan-lentil-recipes")
            val recipeCards4 = DependencyProvider.recipeCardRepo.fetchData("vegan-slow-cooker-recipes")

            //_dailyRecipe.value = dailyRecipe
            _recipeCards1.value = recipeCards1
            _recipeCards2.value = recipeCards2
            _recipeCards3.value = recipeCards3
            _recipeCards4.value = recipeCards4

             */
        }
    }

}