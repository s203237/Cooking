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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.model.Recipe

@Composable
fun RecipeList(recipes: List<Recipe> = testRecipes) {
    Column  {

        Text(
            text = "Recipe List",
            textAlign = TextAlign.Left,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold

        )
        LazyColumn {
            items(recipes) { recipe ->
                RecipeItem(recipe)

            }
        }
    }
}
@Composable
fun RecipeItem(recipe: Recipe, index: Int =0){

Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
){
    Image(painter = painterResource(id= recipe.mainImage),
        contentDescription = recipe.title,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(height = 170.dp)
            .fillMaxWidth(),
        )
    Text(
        text = recipe.title ,
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
}

}
val testRecipes = listOf(
    Recipe("test 1", R.drawable.image,"",10,2,2, "","",listOf(""),listOf("") ),
    Recipe("test 2", R.drawable.image2,"",10,2,2, "","",listOf(""),listOf("")),
    Recipe("test 3", R.drawable.images3,"",10,2,2, "","",listOf(""),listOf("")),
    Recipe("test 4", R.drawable.image4,"",10,2,2, "","",listOf(""),listOf("")),

)
@Preview
@Composable
fun PreviewRecipeList(){
RecipeList()
}


