package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.cooking.model.Recipe
import com.example.cooking.data.RecipeData
//import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.UI.SharedComponents.CustomHeading1
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cooking.UI.SharedComponents.CardFormats
import com.example.cooking.UI.SharedComponents.DisplayFavButton

@Composable
fun RecipePage(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ImageWithFavIcon(
                recipeId = recipe.recipeId,
                imageUrl = recipe.imageUrl,
                {},
                {},
                CardFormats.PORTRAIT
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
            .padding( top = screenWidth)

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
                CustomHeading1(heading = "information")
            }
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clickable { selectedTabIndex = 1 },
                contentAlignment = Alignment.Center
            )
            {
                CustomHeading1(heading = "preparation")
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipePage() {
    val recipeList = RecipeData().loadRecipes()
    RecipePage(recipe = recipeList[2])
}

@Composable
fun ImageWithFavIcon(
    recipeId: String,
    imageUrl: String,
    onNavigateToRecipe: (String) -> Unit,
    onFavoriteButtonClicked: (String) -> Unit,
    cardFormat: CardFormats
) {
    Box(
        // contentAlignment = Alignment.BottomEnd
    ) {
        val aspectRatioImg: Float = when(cardFormat) {
            CardFormats.SQUARE -> 1f
            CardFormats.LANDSCAPE -> 2f
            CardFormats.PORTRAIT -> 0.92f
        }

        val aspectRatioFavBox: Float = when(cardFormat) {
            CardFormats.SQUARE -> 1f
            CardFormats.LANDSCAPE -> 2f
            CardFormats.PORTRAIT -> 1f
        }

        AsyncImage(
            model = imageUrl,
            contentDescription = null, //TODO give content description
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatioImg)
                .clickable {
                    onNavigateToRecipe(recipeId)
                },
            contentScale = ContentScale.Crop,

            )

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatioFavBox)
                .padding(16.dp)
        ) {
            DisplayFavButton()
        }

    }
}