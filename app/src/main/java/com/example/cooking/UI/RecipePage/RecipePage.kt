package com.example.cooking.UI.RecipePage

//import com.example.cooking.data.remote.mock_datasource.RecipeData
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.cooking.UI.SharedComponents.CardFormats
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.UI.SharedComponents.UppercaseHeadingMedium
import com.example.cooking.model.Recipe
import com.example.cooking.model.RecipeCard

@Composable
fun RecipePage(
    recipe: Recipe,
    onFavoriteButtonClicked:(RecipeCard)->Unit
) {
    Column(
        modifier = Modifier
            .testTag("recipePage")
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val recipeCard = RecipeCard(
                recipe.id,
                recipe.name,
                recipe.thumbnail_url,
                emptyList(), //TODO NOT EMPTY LIST! PLACEHOLDER ONLY!
                recipe.isFavorite
            )
            ImageWithFavIcon(
                recipeCard,
                /*onNavigateToRecipe = { recipeId ->
                    navController.navigate(route = "Screens.RecipeItem.name/$recipeId")
                } ,*/
                onNavigateToRecipe = {},
                onFavoriteButtonClicked = {
                    onFavoriteButtonClicked(
                        recipeCard
                    )
                },
                cardFormat = CardFormats.PORTRAIT
            )
            TabLayout(recipe = recipe)
        }
       /* ImageWithFavIcon(recipe = recipe)

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TabLayout(recipe = recipe)
        }*/



    }
}

@Composable
fun TabLayout(recipe: Recipe) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    var selectedTabIndex by remember { mutableStateOf(0) }
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = screenWidth)

    ){
        when (selectedTabIndex) {
            0 -> InfoTab(recipe = recipe)
            1 -> PrepTab(recipe = recipe)
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 8.dp)
                    .clickable { selectedTabIndex = 0 },
                contentAlignment = Alignment.Center

            )
            {
                Spacer(Modifier.height(32.dp))
                UppercaseHeadingMedium(heading = "information")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable { selectedTabIndex = 1 },
                contentAlignment = Alignment.Center
            )
            {
                Spacer(Modifier.height(32.dp))
                UppercaseHeadingMedium(heading = "preparation")
            }
        }
    }
}

//@Preview
//@Composable
//fun PreviewRecipePage() {
//    val recipeList = RecipeData().loadRecipes()
//    RecipePage(recipe = recipeList[2])
//}