package com.example.cooking.UI.Homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.Data.Recipe
import com.example.cooking.R


val testRecipes = listOf(
    Recipe("test 1", R.drawable.image),
    Recipe("test 2", R.drawable.image2),
    Recipe("test 3", R.drawable.images3),
    Recipe("test 4", R.drawable.image4),
    Recipe("test 1", R.drawable.image),
    Recipe("test 2", R.drawable.image2),
    Recipe("test 3", R.drawable.images3),
    Recipe("test 4", R.drawable.image4),
    Recipe("test 1", R.drawable.image),
    Recipe("test 2", R.drawable.image2),
    Recipe("test 3", R.drawable.images3),
    Recipe("test 4", R.drawable.image4),
    Recipe("test 1", R.drawable.image),
    Recipe("test 2", R.drawable.image2),
    Recipe("test 3", R.drawable.images3),
    Recipe("test 4", R.drawable.image4)
)


private val cat1 = testRecipes.subList(0, 4)
private val cat2 = testRecipes.subList(5, 8)
private val cat3 = testRecipes.subList(9, 12)

private val categories: List<List<Recipe>> = listOf(
    cat1, cat2, cat3
)

@Composable
fun RecipeItem(recipe: Recipe, index: Int =0) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = recipe.imageResourceId),
            contentDescription = recipe.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(height = 170.dp)
                .fillMaxWidth(),
        )
        Text(
            text = recipe.name,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun DailyRecipeItem(recipe: Recipe, index: Int =0) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = recipe.imageResourceId),
            contentDescription = recipe.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(height = 170.dp)
                .fillMaxWidth(),
        )
        Text(
            text = "Daily pick",
            fontSize = 10.sp,
            modifier = Modifier.padding(vertical = 3.dp, horizontal = 10.dp)
        )
        Text(
            text = recipe.name,
            fontSize = 20.sp,
            modifier = Modifier.padding(10.dp)
        )
    }
}

private val dailyrecipe = Recipe("Daily test recipe", R.drawable.pear)

@Preview(showBackground = true)
@Composable
fun scrollableList(){
    Surface {
        LazyColumn {
            item {
                    DailyRecipeItem(recipe = dailyrecipe)
            }
            items(categories) { listOfRecipe ->
                Text(
                    text = "test name",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp)
                )
                LazyRow {
                    items(listOfRecipe) { recipe ->
                        RecipeItem(recipe = recipe)
                    }
                }
            }
        }
    }
}