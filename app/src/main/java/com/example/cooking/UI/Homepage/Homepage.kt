package com.example.cooking.UI.Homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.cooking.Data.Recipe
import com.example.cooking.R
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.Recipe
import com.example.cooking.data.TestDataFrontPage


//val testRecipes = listOf(
//    Recipe("test 1", R.drawable.image),
//    Recipe("test 2", R.drawable.image2),
//    Recipe("test 3", R.drawable.images3),
//    Recipe("test 4", R.drawable.image4),
//    Recipe("test 1", R.drawable.image),
//    Recipe("test 2", R.drawable.image2),
//    Recipe("test 3", R.drawable.images3),
//    Recipe("test 4", R.drawable.image4),
//    Recipe("test 1", R.drawable.image),
//    Recipe("test 2", R.drawable.image2),
//    Recipe("test 3", R.drawable.images3),
//    Recipe("test 4", R.drawable.image4),
//    Recipe("test 1", R.drawable.image),
//    Recipe("test 2", R.drawable.image2),
//    Recipe("test 3", R.drawable.images3),
//    Recipe("test 4", R.drawable.image4)
//)


//private val cat1 = testRecipes.subList(0, 4)
//private val cat2 = testRecipes.subList(5, 8)
//private val cat3 = testRecipes.subList(9, 12)
//
//private val categories: List<List<Recipe>> = listOf(
//    cat1, cat2, cat3
//)

//@Composable
//fun RecipeItem(recipe: Recipe, index: Int =0) {
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//    ) {
//        Image(
//            painter = painterResource(id = recipe.imageResourceId),
//            contentDescription = recipe.name,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .height(height = 170.dp)
//                .fillMaxWidth(),
//        )
//        Text(
//            text = recipe.name,
//            fontSize = 20.sp,
//            modifier = Modifier.padding(10.dp)
//        )
//    }
//}

//@Composable
//fun DailyRecipeItem(recipe: Recipe, index: Int =0) {
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//    ) {
//        Image(
//            painter = painterResource(id = recipe.imageResourceId),
//            contentDescription = recipe.name,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .height(height = 170.dp)
//                .fillMaxWidth(),
//        )
//        Text(
//            text = "Daily pick",
//            fontSize = 10.sp,
//            modifier = Modifier.padding(vertical = 3.dp, horizontal = 10.dp)
//        )
//        Text(
//            text = recipe.name,
//            fontSize = 20.sp,
//            modifier = Modifier.padding(10.dp)
//        )
//    }
//}

//private val dailyrecipe = Recipe("Daily test recipe", R.drawable.pear)


@Composable
fun scrollableList(
    dailyRecipe: Recipe,
    cat1Recipe: List<Recipe>,
    cat2Recipe: List<Recipe>,
    cat3Recipe: List<Recipe>,
    cat4Recipe: List<Recipe>,
    cat5Recipe: List<Recipe>
){
    Surface {
        LazyColumn {
            item {
//                    DailyRecipeItem(recipe = dailyrecipe)
                RecipeCard(recipe = dailyRecipe)
            }
//            items(categories) { listOfRecipe ->
//                Text(
//                    text = "test name",
//                    fontSize = 20.sp,
//                    modifier = Modifier.padding(10.dp)
//                )
//                LazyRow {
//                    items(listOfRecipe) { recipe ->
////                        RecipeItem(recipe = recipe)
//                    }
//                }
//            }
            item{
                Text(
                    text = "test 1",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                LazyRow {
                    items(cat1Recipe) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }
            }
            item{
                Text(
                    text = "test 2",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                LazyRow {
                    items(cat2Recipe) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }
            }
            item{
                Text(
                    text = "test 3",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                LazyRow {
                    items(cat3Recipe) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }
            }
            item{
                Text(
                    text = "test 4",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                LazyRow {
                    items(cat4Recipe) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }
            }
            item{
                Text(
                    text = "test 5",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                LazyRow {
                    items(cat5Recipe) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewscrollableList(){

    val dailyRecipe = TestDataFrontPage().dailyRecipe()
    val recipeList1 = TestDataFrontPage().loadCat1Recipes()
    val recipeList2 = TestDataFrontPage().loadCat2Recipes()
    val recipeList3 = TestDataFrontPage().loadCat3Recipes()
    val recipeList4 = TestDataFrontPage().loadCat4Recipes()
    val recipeList5 = TestDataFrontPage().loadCat5Recipes()

    scrollableList(
        dailyRecipe = dailyRecipe,
        cat1Recipe = recipeList1,
        cat2Recipe = recipeList2,
        cat3Recipe = recipeList3,
        cat4Recipe = recipeList4,
        cat5Recipe = recipeList5,
    )


}


