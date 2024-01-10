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

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.UI.SharedComponents.CardFormats
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
//import com.example.cooking.data.remote.mock_datasource.RecipeData
import com.example.cooking.model.RecipeCard

@Composable

fun RecipeList(
    recipes: List<RecipeCard>,
    onNavigateToRecipe: (Int) -> Unit,
    onFavoriteButtonClicked: (Int) -> Unit ) {
    Column (
       /* modifier = Modifier
            .background(color = Color(0xFFFFFBEF))*/
    ) {
        Text(
            text = "Favorites",
            textAlign = TextAlign.Left,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )
        LazyColumn {
            items(recipes) { recipe ->
                RecipeItem(recipe, onNavigateToRecipe , onFavoriteButtonClicked )
                println("Composed recipe item")
            }
        }
    }
}
@Composable
fun RecipeItem(recipe: RecipeCard, onNavigateToRecipe: (Int) -> Unit, onFavoriteButtonClicked: (Int) -> Unit){
    println("Composing RecipeItem: ${recipe.id}, isFavorite: ${recipe.isFavorite}")
Column(
    modifier = Modifier
        .fillMaxWidth()
){
    ImageWithFavIcon(
        recipeId = recipe.id,
        imageUrl = recipe.thumbnail_url,
        onNavigateToRecipe = onNavigateToRecipe,
        isFavorite = recipe.isFavorite,
        onFavoriteButtonClicked = {
            println("Favorite button clicked for recipeId: ${recipe.id}")
            onFavoriteButtonClicked(recipe.id)},
        cardFormat = CardFormats.LANDSCAPE
    )
    Text(
        text = recipe.name ,
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
//val testRecipes = RecipeData().loadRecipes()
/*val testRecipes = listOf(
    Recipe("test 1", R.drawable.image,"",10,2,2, "","",listOf(""),listOf("") ),
    Recipe("test 2", R.drawable.image2,"",10,2,2, "","",listOf(""),listOf("")),
    Recipe("test 3", R.drawable.images3,"",10,2,2, "","",listOf(""),listOf("")),
    Recipe("test 4", R.drawable.image4,"",10,2,2, "","",listOf(""),listOf("")),

)*/
@Preview
@Composable
fun PreviewRecipeList(){
    RecipeList(emptyList(), onNavigateToRecipe = {} , onFavoriteButtonClicked = {})
}