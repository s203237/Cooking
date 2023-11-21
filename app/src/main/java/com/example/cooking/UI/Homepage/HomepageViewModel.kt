package com.example.cooking.UI.Homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cooking.DependencyProvider
import com.example.cooking.data.HomepageCuration
import com.example.cooking.model.RecipeCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import kotlin.random.Random

class HomePageViewModel: ViewModel() {
    private val collectionNames = HomepageCuration().loadCollectionNames()
    private val collectionCount = HomepageCuration().getCollectionsCount()

    private val _recipeCardsList: List<MutableStateFlow<List<RecipeCard>>> = List(collectionCount) {
        MutableStateFlow(emptyList())
    }
    private val _dailyRecipe = MutableStateFlow(RecipeCard())

   /* private val _recipeCards1 = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards2 = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards3 = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards4 = MutableStateFlow<List<RecipeCard>>(emptyList())
    private val _recipeCards5 = MutableStateFlow<List<RecipeCard>>(emptyList())*/

    val dailyRecipe = _dailyRecipe.asStateFlow()
    val recipeCardsList: List<StateFlow<List<RecipeCard>>> = _recipeCardsList.map { it.asStateFlow() }

    private fun pickNumber(collectionSize: Int): Int {
        val calendar = Calendar.getInstance()
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        return if(collectionSize > 0)
            dayOfMonth % collectionSize
        else
            0
    }
  private fun getDailyRecipe() : RecipeCard{
      val randomNumber = (0 until collectionCount).random() //TODO pick using computer's date?? So it only changes once a day...
      val randomListIndex = _recipeCardsList[randomNumber].value.size
      val dailyPickNum = pickNumber(randomListIndex)

      if (_recipeCardsList.isNotEmpty()) {
          return _recipeCardsList[randomListIndex].value[Random.nextInt(dailyPickNum)]
      }
      return RecipeCard()
  }
   /* val recipeCards1 = _recipeCards1.asStateFlow()
    val recipeCards2 = _recipeCards2.asStateFlow()
    val recipeCards3 = _recipeCards3.asStateFlow()
    val recipeCards4 = _recipeCards4.asStateFlow()*/

    init {
        viewModelScope.launch(Dispatchers.IO) {
            //val dailyRecipe = DependencyProvider.recipeSingleCardRepo.fetchData("miso-butternut-soup")
            /*val recipeCards1 = DependencyProvider.recipeCardRepo.fetchData(collectionNames[0])
            val recipeCards2 = DependencyProvider.recipeCardRepo.fetchData(collectionNames[1])
            val recipeCards3 = DependencyProvider.recipeCardRepo.fetchData(collectionNames[2])
            val recipeCards4 = DependencyProvider.recipeCardRepo.fetchData(collectionNames[3])
            //val listRecipeCards = DependencyProvider.recipeCardRepo.fetchData(_collectionNames.value[0])
            //_dailyRecipe.value = dailyRecipe
            _recipeCards1.value = recipeCards1
            _recipeCards2.value = recipeCards2
            _recipeCards3.value = recipeCards3
            _recipeCards4.value = recipeCards4*/

            for (i in 0 until collectionCount) {
                val recipe = DependencyProvider.recipeCardRepo.fetchData(collectionNames[i])
                _recipeCardsList[i].value = recipe
            }

            _dailyRecipe.value = getDailyRecipe()
        }
    }
}