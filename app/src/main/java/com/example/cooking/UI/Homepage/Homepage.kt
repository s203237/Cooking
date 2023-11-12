package com.example.cooking.UI.Homepage

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
//import com.example.cooking.Data.Recipe
import com.example.cooking.UI.SharedComponents.BackToTop
import com.example.cooking.data.remote.RecipeCard
import com.example.cooking.model.Recipe
import com.example.cooking.model.FoodCategories

@Composable
fun scrollableList(
    modifier: Modifier,
    //dailyRecipe: RecipeCard,
    listOfList: List<FoodCategories>,
    onNavigateToRecipe: (String) -> Unit
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
                //RecipeCard(recipe = dailyRecipe, "Daily Recipe")
                //RecipeItem(dailyRecipe, onNavigateToRecipe)
            }

            /*items(listOfList) { listOfList ->
                Text(
                    text = "test 1",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "View more", // Need to be button sending user to category
                    fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                LazyRow {
                    /*items(listOfList) { recipe ->
                        RecipeCard(recipe = recipe)
                    }*/
                    /*itemsIndexed(listOfList) { index, recipe ->
                        RecipeItem(recipe, index, onNavigateToRecipe)
                    }*/
                    /*items(listOfList) { recipe ->
                        RecipeItem(recipe, 0, onNavigateToRecipe)
                    }*/
                }
            }*/

            items(listOfList){listOfList->
                Text(
                    text = listOfList.getName(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = "View more", // Need to be button sending user to category
                    fontSize = 20.sp,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                LazyRow {
                    items(listOfList.getList()) { recipe ->
                        //RecipeCard(recipe = recipe)
                        RecipeItem(recipe, onNavigateToRecipe)
                    }
                }
            }


        }
    }

    AnimatedVisibility(visible = showButton, enter = fadeIn(), exit = fadeOut()) {
        BackToTop(listState, coroutineScope) { }
    }

}

@Composable
fun RecipeItem(recipe: RecipeCard, onNavigateToRecipe: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Card(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        ){
            AsyncImage(
                model = recipe.imageUrl,
                contentDescription = null, //TODO give content description
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.92f)
                    .clickable { onNavigateToRecipe(recipe.recipeId) },
                contentScale = ContentScale.Crop,
                )
        }
        val recipeTitle = recipe.title
        println("this is the recipe title: $recipeTitle")
        Text(
            text = recipe.title,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp).width(200.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
/*
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
*/

