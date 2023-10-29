package com.example.cooking.UI.Homepage

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.cooking.Data.Recipe
import com.example.cooking.R
import com.example.cooking.UI.SharedComponents.BackToTop
import com.example.cooking.data.RecipeData
import com.example.cooking.data.dailyRecipe
import com.example.cooking.data.loadCat1Recipes
import com.example.cooking.data.loadCat2Recipes
import com.example.cooking.data.loadCat3Recipes
import com.example.cooking.data.loadCat4Recipes
import com.example.cooking.data.loadCat5Recipes
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.Recipe
import java.util.Objects

@Composable
fun scrollableList(
    modifier: Modifier,
    dailyRecipe: Recipe,
    listOfList: List<List<Recipe>>
){

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }


    Surface {
        LazyColumn(
            modifier = modifier,
            state = listState
        ) {
            item {
//                    DailyRecipeItem(recipe = dailyrecipe)
                RecipeCard(recipe = dailyRecipe, "Daily Recipe")
            }

            items(listOfList) { listOfList ->
                Text(
                    text = "test 1",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "View more", // Need to be button sending user to category
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp),
                    color = Color.Blue
                )
                LazyRow {
                    items(listOfList) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }

            }

        }
    }

    AnimatedVisibility(visible = showButton, enter = fadeIn(), exit = fadeOut()) {
        BackToTop(listState, coroutineScope) { }
    }

}

@Preview
@Composable
fun PreviewscrollableList(){
/*
    val dailyRecipe = testingClass().dailyRecipe()
    val recipeList1 = testingClass().loadCat1Recipes()
    val recipeList2 = testingClass().loadCat2Recipes()
    val recipeList3 = testingClass().loadCat3Recipes()
    val recipeList4 = testingClass().loadCat4Recipes()
    val recipeList5 = testingClass().loadCat5Recipes()
*/
    val dailyRecipe = RecipeData().loadRecipes()[0]
    val recipeList1 = RecipeData().loadRecipes()
    val recipeList2 = RecipeData().loadRecipes()
    val recipeList3 = RecipeData().loadRecipes()
    val recipeList4 = RecipeData().loadRecipes()
    val recipeList5 = RecipeData().loadRecipes()


    val listOfList: List<List<Recipe>> = listOf(
        recipeList1, recipeList2, recipeList3, recipeList4, recipeList5
    )

    scrollableList(
        Modifier,
        dailyRecipe = dailyRecipe,
        listOfList = listOfList,
    )


}


