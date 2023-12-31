package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomePageViewModel: ViewModel() {

    //private val _dailyRecipe = MutableStateFlow(RecipeCard())

    private val _recipeCards1 = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards2 = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards3 = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards4 = MutableStateFlow<List<RecipeCard>>(emptyList())

    //val dailyRecipe = _dailyRecipe.asStateFlow()

    val recipeCards1 = _recipeCards1.asStateFlow()
    val recipeCards2 = _recipeCards2.asStateFlow()
    val recipeCards3 = _recipeCards3.asStateFlow()
    val recipeCards4 = _recipeCards4.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //val dailyRecipe = DependencyProvider.recipeSingleCardRepo.fetchData("miso-butternut-soup")

            val recipeCards1 = DependencyProvider.newrecipeCardRepo.fetchData("tofu")
//            val recipeCards2 = DependencyProvider.newrecipeCardRepo.fetchData("carrot")
//            val recipeCards3 = DependencyProvider.newrecipeCardRepo.fetchData("pasta")
//            val recipeCards4 = DependencyProvider.newrecipeCardRepo.fetchData("salad")

            //_dailyRecipe.value = dailyRecipe
            _recipeCards1.value = recipeCards1
            _recipeCards2.value = recipeCards1
            _recipeCards3.value = recipeCards1
            _recipeCards4.value = recipeCards1

//            _recipeCards2.value = recipeCards2
//            _recipeCards3.value = recipeCards3
//            _recipeCards4.value = recipeCards4


        }
    }
}