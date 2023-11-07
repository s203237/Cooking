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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.cooking.R
import com.example.cooking.UI.NavBar.navigation.Navigator
import com.example.cooking.model.Recipe
import com.example.cooking.data.RecipeData

@Composable
fun RecipeList(recipes: List<Recipe> = testRecipes, onNavigateToRecipe: (Int) -> Unit) {
    val navController = rememberNavController()
    Column (modifier = Modifier.background(color = Color(0xffF2ECE3))) {
      Row {
          IconButton(onClick = { Navigator.navController.popBackStack() }) {
              Icon(
                  painter = painterResource(id = R.drawable.arrow_back),
                  contentDescription = "",
                  tint = Color.Black,
                  modifier = Modifier
              )
          }
          Spacer(modifier = Modifier.width(40.dp))

          Text(
              text = "Recipe List",
              textAlign = TextAlign.Left,
              fontSize = 30.sp,
              fontWeight = FontWeight.Bold

          )
      }
        LazyColumn {
            itemsIndexed(recipes) { index, recipe ->
                RecipeItem(recipe, index, onNavigateToRecipe)

            }
        }
    }
}
@Composable
fun RecipeItem(recipe: Recipe, index: Int, onNavigateToRecipe: (Int) -> Unit){

Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
){
    Image(painter = painterResource(id= recipe.mainImage),
        contentDescription = recipe.title,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(height = 170.dp)
            .fillMaxWidth()
            .clickable { onNavigateToRecipe(index) }
        )
    Text(
        text = recipe.title ,
        fontSize = 20.sp,
        modifier = Modifier.padding(10.dp)
    )
}

}
val testRecipes = RecipeData().loadRecipes()
/*val testRecipes = listOf(
    Recipe("test 1", R.drawable.image,"",10,2,2, "","",listOf(""),listOf("") ),
    Recipe("test 2", R.drawable.image2,"",10,2,2, "","",listOf(""),listOf("")),
    Recipe("test 3", R.drawable.images3,"",10,2,2, "","",listOf(""),listOf("")),
    Recipe("test 4", R.drawable.image4,"",10,2,2, "","",listOf(""),listOf("")),

)*/
@Preview
@Composable
fun PreviewRecipeList(){
RecipeList(onNavigateToRecipe = {})
}


