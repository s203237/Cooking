/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cooking.UI.RecipeList

//import com.example.cooking.data.remote.mock_datasource.RecipeData
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.UI.SharedComponents.CardFormats
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.UI.SharedComponents.UppercaseHeadingSmall
import com.example.cooking.UI.theme.CookingTheme
import com.example.cooking.model.RecipeCard

@Composable
fun RecipeList(
    recipeCards: List<RecipeCard>,
    onNavigateToRecipe: (Int) -> Unit,
    modifier: Modifier
) {
    Log.v("RecipeList", recipeCards.toString())
    Column {
        /*Spacer(Modifier.height(16.dp))
        Text(
            text = "Recipe List",
            textAlign = TextAlign.Left,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier
        )

        Spacer(Modifier.height(16.dp))

*/
        Spacer(Modifier.height(16.dp))
        LazyColumn {
            items(recipeCards) { recipe ->
                RecipeItem(recipe, onNavigateToRecipe)
                println("Composed recipe item")
            }
        }
    }
}
@Composable
fun RecipeItem(recipe: RecipeCard, onNavigateToRecipe: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ImageWithFavIcon(
            recipeId = recipe.id,
            imageUrl = recipe.thumbnail_url,
            onNavigateToRecipe = onNavigateToRecipe,
            onFavoriteButtonClicked = {},
            cardFormat = CardFormats.LANDSCAPE
        )
        Text(
            text = recipe.name,
            fontSize = 20.sp,
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 32.dp
            )
        )
    }
}

@Composable
fun FilterMenu(onApplyFilters: (List<String>) -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column{
            Button(
                onClick = {
                    isVisible = !isVisible
                }
            ) {
                Text(
                    text = "filters"
                )
            }
            if(isVisible) {
                UppercaseHeadingSmall(heading = "difficulty")

                    Text(
                        text = "easy",
                        modifier = Modifier
                            .clickable {
                                val easy = listOf("5_ingredients_or_less")
                                println(easy)
                                onApplyFilters(easy)
                            }
                    )

            }

        }

    }

}

@Preview
@Composable
fun PreviewFilterMenu(){
    FilterMenu(onApplyFilters = {})
}

@Preview
@Composable
fun PreviewRecipeList(){
    val modifier = Modifier
        .padding(
            start = 16.dp,
            end = 16.dp
        )
        .background(color = MaterialTheme.colorScheme.background)
        .fillMaxWidth()

    val recipeCards = loadTestCardsWithTags()
    CookingTheme {
        RecipeList(recipeCards, onNavigateToRecipe = {}, modifier = modifier)
    }

}


