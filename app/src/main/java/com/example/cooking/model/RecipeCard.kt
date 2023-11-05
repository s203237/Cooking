package com.example.cooking.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R

@Composable
fun RecipeCard(recipe: Recipe, subTitle: String ="") =
    Column {
        Card(
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(recipe.imageUrl),
                    contentDescription = recipe.imageDescription,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop,

                    )
                Box(
                    modifier = Modifier
                        .padding(22.dp)
                ) {
                    DisplayFavButton()
                }
            }
        }
        if(!subTitle.equals("")) {
            Text(
                text = subTitle,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
        Text(
            text = recipe.title,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
    }


@Preview
@Composable
fun PreviewRecipeCard(){
    val recipe = Recipe(
        title = "Peach",
        imageUrl = R.drawable.peach,
        imageDescription = "3d rendering of a close-up of a peach with googly eyes",
        prepTime = 10,
        cookingTime = 610,
        servingSize = 10,
        difficulty = "Easy",
        rating = 3.4f,
        author = "Hej Med Dig",
        recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous.",
        ingredients = listOf("Peach", "Googly eyes", "Salmon paint"),
        steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
    )
    RecipeCard(recipe = recipe)
}

