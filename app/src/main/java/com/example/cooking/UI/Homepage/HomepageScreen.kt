package com.example.cooking.UI.Homepage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.data.RecipeData
import com.example.cooking.model.FoodCategories
import com.example.cooking.model.Recipe
import kotlin.random.Random


@Composable
fun HomepageScreen(onNavigateToRecipe: (String) -> Unit){

    val viewModel: HomePageViewModel = viewModel()

    //val dailyRecipe by viewModel.dailyRecipe.collectAsState()

    //val dailyRecipe = RecipeData().loadRecipes()[0]

    val recipeList1 by viewModel.recipeCards1.collectAsState()
    val recipeList2 by viewModel.recipeCards2.collectAsState()
    val recipeList3 by viewModel.recipeCards3.collectAsState()
    val recipeList4 by viewModel.recipeCards4.collectAsState()

    val food1 = FoodCategories(categoryName = "high protein vegan recipes", categoryListOfRecipe = recipeList1)
    val food2 = FoodCategories(categoryName = "vegan winter recipes", categoryListOfRecipe = recipeList2)
    val food3 = FoodCategories(categoryName = "vegan lentil recipes", categoryListOfRecipe = recipeList3)
    val food4 = FoodCategories(categoryName = "vegan slow cooker recipes", categoryListOfRecipe = recipeList4)


    val listOfList: List<FoodCategories> = listOf(
        food1, food2, food3, food4
    )

    val randomNumber = (0..3).random()

    var list = food1.getList()

    when (randomNumber) {
        0 -> list = food1.getList()
        1 -> list = food2.getList()
        2 -> list = food3.getList()
        else -> list = food4.getList()
    }

    if(list.size > 0) {
        val dailyRecipe = list[Random.nextInt(list.size)]

        scrollableList(
            Modifier,
            dailyRecipe = dailyRecipe,
            listOfList = listOfList,
            onNavigateToRecipe = onNavigateToRecipe
        )
    }



}