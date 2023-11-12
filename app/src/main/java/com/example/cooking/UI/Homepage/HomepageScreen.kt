package com.example.cooking.UI.Homepage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
//import com.example.cooking.data.remote.RecipeCard
import com.example.cooking.model.FoodCategories

@Composable
fun HomepageScreen(){

    val viewModel: HomePageViewModel = viewModel()
    //val dailyRecipe by viewModel.dailyRecipe.collectAsState()
    //val dailyRecipe2 = RecipeCard(recipe = dailyRecipe)

    val recipeList by viewModel.recipeCards.collectAsState()

    //val dailyRecipeList by viewModel.dailyRecipe.collectAsState()
    //val dailyRecipe = dailyRecipeList[0]
    /*val templist: List<Recipe> = listOf(
        dailyRecipe, dailyRecipe, dailyRecipe, dailyRecipe, dailyRecipe, dailyRecipe
    )
*/
    /*val listOfList: List<List<RecipeCard>> = listOf(
        recipeList, recipeList, recipeList, recipeList, recipeList
    )
/*
    val listOfList: List<List<Recipe>> = listOf(
        templist, templist, templist, templist, templist
    )
*/

    val dailyRecipe = RecipeData().loadRecipes()[0]
    /*val recipeList1 = RecipeData().loadRecipes()
    val recipeList2 = RecipeData().loadRecipes()
    val recipeList3 = RecipeData().loadRecipes()
    val recipeList4 = RecipeData().loadRecipes()
    val recipeList5 = RecipeData().loadRecipes()

*/
    val listOfList: List<List<Recipe>> = listOf(
        recipeList1, recipeList2, recipeList3, recipeList4, recipeList5
    )
*/

    //val dailyRecipe = RecipeData().loadRecipes()[0]
    //val dailyRecipe = recipeList[0]


    val food1 = FoodCategories(categoryName = "food1", categoryListOfRecipe = recipeList)
    val food2 = FoodCategories(categoryName = "food2", categoryListOfRecipe = recipeList)
    val food3 = FoodCategories(categoryName = "food3", categoryListOfRecipe = recipeList)
    val food4 = FoodCategories(categoryName = "food4", categoryListOfRecipe = recipeList)
    val food5 = FoodCategories(categoryName = "food5", categoryListOfRecipe = recipeList)


    val listOfList: List<FoodCategories> = listOf(
        food1, food2, food3, food4, food5
    )


    scrollableList(
        Modifier,
        //dailyRecipe = dailyRecipe,
        listOfList = listOfList
    ) {}
}