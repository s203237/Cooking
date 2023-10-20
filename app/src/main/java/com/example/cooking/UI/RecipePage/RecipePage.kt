package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cooking.model.Recipe
import com.example.cooking.data.RecipeData
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.UI.SharedComponents.CustomHeading

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ImageWithFavIcon(recipe = recipe)

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TabLayout(recipe = recipe)
        }



    }
}

@Composable
fun TabLayout(recipe: Recipe) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Box (
        modifier = Modifier.fillMaxWidth()
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
                .clickable { selectedTabIndex = 0 },
                contentAlignment = Alignment.Center

            )
            {
                CustomHeading(heading = "information")
            }
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .clickable { selectedTabIndex = 1 },
                contentAlignment = Alignment.Center
            )
            {
                CustomHeading(heading = "preparation")
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipePage() {
    val recipeList = RecipeData().loadRecipes()
    RecipeCard(recipe = recipeList[2], modifier = Modifier)
}