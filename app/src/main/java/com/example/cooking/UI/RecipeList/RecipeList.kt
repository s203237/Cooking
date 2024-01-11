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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.cooking.UI.SharedComponents.UppercaseHeadingMedium
import com.example.cooking.UI.theme.CookingTheme
import com.example.cooking.model.RecipeCard
import com.example.cooking.model.Tag

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

@Preview
@Composable
private fun printMap() {
    //val map = getFiltersMap()

    val filters = getFiltersList()

    filters.groupBy { it.type }.forEach {println("${it.key} -> ${it.value}")}

}

@Composable
fun FilterMenu(onSelect: (String) -> Unit, onApplyFilters: () -> Unit, onResetFilters: () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    var filters by remember {  mutableStateOf(emptySet<String>()) }
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        LazyColumn {
            item {
                Button(
                    onClick = {
                        isVisible = !isVisible
                    }
                ) {
                    Text(
                        text = "filters"
                    )
                }
            }
            if(isVisible) {
                getFiltersList()
                    .groupBy { it.type }
                    .forEach {
                        item { UppercaseHeadingMedium(heading = it.key) }
                        items(it.value) { value ->
                            var isSelected by remember { mutableStateOf(false) }
                            FilterButton(
                                label = value.displayName,
                                onClick = {
                                    isSelected = !isSelected
                                    onSelect(value.name)
                                    /*if (isSelected)
                                        filters += value.name
                                    else
                                        filters -= value.name*/
                                },
                                isSelected = isSelected
                            )
                        }
                    }

                item {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(onClick = { onApplyFilters() }) {
                            Text(text = "Apply")
                        }
                        Button(onClick = { onResetFilters() }) {
                            Text(text = "Reset")
                        }
                    }

                }

            }
        }


        /* Column{
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
                 var isSelected by remember { mutableStateOf(false) }
                 FilterButton(
                     label = "TEST 5 INGRE",
                     onClick = {
                         isSelected = !isSelected
                         if(isSelected)
                             filters += "5_ingredients_or_less"
                         else
                             filters -= "5_ingredients_or_less"
                     },
                     isSelected
                 )

                 UppercaseHeadingSmall(heading = "dietary")
                 var isSelected2 by remember { mutableStateOf(false) }
                 FilterButton(
                     label = "TEST DAIRY FREE",
                     onClick = {
                         isSelected2 = !isSelected2
                         if(isSelected2)
                             filters += "dairy_free"
                         else
                             filters -= "dairy_free"
                     },
                     isSelected2
                 )

                 var isSelected3 by remember { mutableStateOf(false) }
                 FilterButton(
                     label = "TEST GLUTEN FREE",
                     onClick = {
                         isSelected3 = !isSelected3
                         if(isSelected3)
                             filters += "gluten_free"
                         else
                             filters -= "gluten_free"
                     },
                     isSelected3
                 )

                 Button(onClick = { onApplyFilters(filters) }) {
                     Text(text = "Apply")
                 }

             }

         }*/

    }

}

@Composable
fun FilterButton(label: String, onClick: () -> Unit, isSelected: Boolean) {
    var color = if (isSelected) {
        ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
        )

    } else {
        ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
        )
    }
    Button(
        onClick = onClick,
        colors = color

    ) {
        Text(text = label)
    }
}

private fun getFiltersList(): List<Tag> {
    //TODO figure out where to put this function
    return listOf(
        Tag(name = "easy", displayName = "Easy", type = "Difficulty"),
        Tag(name = "5_ingredients_or_less", displayName = "5 ingredients or less", type = "Difficulty"),
        Tag(name = "dairy_free", displayName = "Dairy Free", type = "Dietary"),
        Tag(name = "gluten_free", displayName = "Gluten Free", type = "Dietary"),
        Tag(name = "asian", displayName = "Asian", type = "Cuisine")
    )
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


