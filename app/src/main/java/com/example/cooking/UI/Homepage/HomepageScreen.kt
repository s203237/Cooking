package com.example.cooking.UI.Homepage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cooking.UI.RecipeList.RecipeList
import com.example.cooking.UI.RecipeList.RecipeListViewModel
import com.example.cooking.data.remote.RecipeCard
import com.example.cooking.model.Recipe

@Composable
fun HomepageScreen(){

    val viewModel: HomePageViewModel = viewModel()
    val dailyRecipe by viewModel.dailyRecipe.collectAsState()
    val recipeList by viewModel.recipeCards.collectAsState()

    val listOfList: List<List<RecipeCard>> = listOf(
        recipeList, recipeList, recipeList, recipeList, recipeList
    )

    scrollableList(
        Modifier,
        dailyRecipe = dailyRecipe,
        listOfList = listOfList,
        onNavigateToRecipe = {}
    )
}