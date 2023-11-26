package com.example.cooking.UI.Homepage

//import com.example.cooking.Data.Recipe
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.UI.SharedComponents.BackToTop
import com.example.cooking.UI.SharedComponents.CardFormats
import com.example.cooking.UI.SharedComponents.FavButton
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.UI.SharedComponents.RecipeImage
import com.example.cooking.UI.SharedComponents.UppercaseHeadingMedium
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
                UppercaseHeadingMedium(heading = "daily pick")
                RecipeItem(modifier = Modifier.fillMaxWidth(), recipe = dailyRecipe, onNavigateToRecipe = onNavigateToRecipe)

            }

            items(listOfList) { listOfList ->
                Spacer(Modifier.height(16.dp))
                UppercaseHeadingMedium(heading = listOfList.getName())
                Spacer(Modifier.height(16.dp))

                LazyRow {
                    items(listOfList.getList()) { recipe ->
                        //RecipeCard(recipe = recipe)
                        RecipeItem(modifier = Modifier
                            .height(200.dp)
                            .width(200.dp), recipe = recipe, onNavigateToRecipe = onNavigateToRecipe)
                    }
                }

            }

        }
    }

    AnimatedVisibility(visible = showButton, enter = fadeIn(), exit = fadeOut()) {
        BackToTop(listState, coroutineScope) { }
    }

}


/*@Preview
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
    val dailyRecipe = Recipe()
    val recipeCardList = RecipeData().loadRecipeCards()

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
            .padding(
                end = 10.dp,
            )
    ) {
        Card(
            modifier = modifier
        ){
            ImageWithFavIcon(
                recipeId = recipe.recipeId,
                imageUrl = recipe.imageUrl,
                onNavigateToRecipe = onNavigateToRecipe,
                onFavoriteButtonClicked = {},
                cardFormat = CardFormats.SQUARE
            )
        }
        val recipeTitle = recipe.title
        println("this is the recipe title: $recipeTitle")
        Text(
            text = recipe.title,
            fontSize = 16.sp,
            modifier = Modifier
                .width(200.dp)
                .padding(
                    top = 8.dp,
                    bottom = 16.dp
                ),
            //maxLines = 1,
            //overflow = TextOverflow.Ellipsis
        )
        if(subtitle != ""){
            Text(
                text = subtitle,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .width(200.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun RecipeCardListItem(recipeCard: RecipeCard, onNavigateToRecipe: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .padding(16.dp)
            .clickable {
                onNavigateToRecipe(recipeCard.recipeId)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.6f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RecipeImage(
                recipeId = recipeCard.recipeId,
                imageUrl = recipeCard.imageUrl,
                onNavigateToRecipe = onNavigateToRecipe,
                cardFormat = CardFormats.SQUARE,
                sizeFraction = 0.35f
            )
            Text(
                text = recipeCard.title,
                color = MaterialTheme.colorScheme.onBackground,
                /*modifier = Modifier
                    .fillMaxWidth(0.3f)*/
            )

        }
        FavButton(0.35f)
    }
}

@Preview
@Composable
fun PreviewRecipeCardListItem() {
    val recipeCard = RecipeCard(
        recipeId = "miso-butternut-soup",
        title = "Miso Butternut Soup",
        imageUrl = "https://images.immediate.co.uk/production/volatile/sites/30/2021/09/Miso-and-butternut-soup-efe9277.jpg?quality=90&webp=true&resize=600,545"
    )
    RecipeCardListItem(recipeCard = recipeCard, onNavigateToRecipe = {})
}

