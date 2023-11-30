package com.example.cooking.UI.Homepage

//import com.example.cooking.Data.Recipe
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.UI.SharedComponents.BackToTop
import com.example.cooking.UI.SharedComponents.CardFormats
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.model.FoodCategories
import com.example.cooking.model.RecipeCard

@Composable
fun scrollableList(
    modifier: Modifier,
    dailyRecipe: RecipeCard,
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
                RecipeItem(modifier = Modifier.fillMaxWidth(), recipe = dailyRecipe, onNavigateToRecipe = onNavigateToRecipe, subtitle = "Daily recipe")
            }

            items(listOfList) { listOfList ->
                Text(
                    text = listOfList.getName(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                LazyRow {
                    items(listOfList.getList()) { recipe ->
                        //RecipeCard(recipe = recipe)
                        RecipeItem(modifier = Modifier.height(200.dp).width(200.dp), recipe = recipe, onNavigateToRecipe = onNavigateToRecipe)
                    }
                }

            }

        }
    }

    AnimatedVisibility(visible = showButton, enter = fadeIn(), exit = fadeOut()) {
        BackToTop(listState, coroutineScope) { }
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
@Composable
fun RecipeItem(modifier: Modifier, recipe: RecipeCard, onNavigateToRecipe: (String) -> Unit, subtitle: String = "") {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    ) {
        Card(
            modifier = modifier
        ){
//            AsyncImage(
//                model = recipe.imageUrl,
//                contentDescription = null, //TODO give content description
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(0.92f)
//                    .clickable { onNavigateToRecipe(recipe.recipeId) },
//                contentScale = ContentScale.Crop,
//            )
            ImageWithFavIcon(
                recipeId = recipe.recipeId,
                imageUrl = recipe.imageUrl,
                onNavigateToRecipe = onNavigateToRecipe,
                onFavoriteButtonClicked ={} ,
                cardFormat = CardFormats.SQUARE
            )
        }
        val recipeTitle = recipe.title
        println("this is the recipe title: $recipeTitle")
        Text(
            text = recipe.title,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp)
                .width(200.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        if(!subtitle.equals("")){
            Text(
                text = subtitle,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .width(200.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
