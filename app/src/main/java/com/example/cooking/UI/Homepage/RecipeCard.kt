package com.example.cooking.UI.Homepage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cooking.model.Recipe

@Composable
fun RecipeCard(recipe: Recipe, subTitle: String ="") =
    Column {
        Card(
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                AsyncImage(
                    model = recipe.imageUrl,
                    contentDescription = null, //TODO give content description
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(0.92f),
                    contentScale = ContentScale.Crop,

                    )
               /* Image(
                    painter = painterResource(recipe.imageUrl),
                    contentDescription = recipe.imageDescription,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop,

                    )*/
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
        imageUrl = "app/src/main/res/drawable/peach.png",
        isFavorite = false,
        imageDescription = "3d rendering of a close-up of a peach with googly eyes"/*,
        timeToCook = TimeToCook("10 min", "1h30 min"),
        difficulty = "Easy",
        servingSize = "10",
        rating = 3.4f,
        author = "Hej Med Dig",
        recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous.",
        ingredients = listOf("Peach", "Googly eyes", "Salmon paint"),
        steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
    */)
    RecipeCard(recipe = recipe)
}

