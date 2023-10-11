package com.example.cooking.UI.recipe_page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.model.Recipe
import com.example.cooking.UI.sharedComponents.Display
import com.example.cooking.UI.sharedComponents.Formatting

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    val display = Display()
    val format = Formatting()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        display.ImageWithFavIcon(recipe = recipe)
        DisplayRecipeInfo(recipe = recipe)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            format.Heading(heading = "description")
            Text(
                text = recipe.recipeDescription,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )

            format.Heading(heading = "ingredients")
            BulletList(list = recipe.ingredients)

            format.Heading(heading = "steps")
            StepsList(list = recipe.steps)
        }



    }
}


private fun formatTime(minutes: Int): String {
    val formattedTime: String = if(minutes < 2) {
        "$minutes minute"
    } else if (minutes < 60) {
        "$minutes minutes"
    } else {
        val hrs = minutes / 60
        val min = minutes % 60
        val formattedMin = if (min < 10) "0$min" else min.toString()
        "$hrs hr $formattedMin min"
    }
    return formattedTime
}

@Composable
fun DisplayRecipeInfo(recipe: Recipe) {
    val tableData = listOf(
        formatTime(recipe.prepTime),
        formatTime(recipe.cookingTime),
        recipe.servingSize.toString(),
        recipe.difficulty,
    )
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        val rowCount = 2
        val colCount = 2
        for(rowIndex in 0 until rowCount) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                for(colIndex in 0 until colCount){
                    val cellIndex = rowIndex * 2 + colIndex
                    Text(text = tableData[cellIndex])
                }
            }
        }
    }
}

@Composable
fun BulletList(list: List<String>) {
    list.forEach { item ->
        Text(text =  "• $item",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun StepsList(list: List<String>) {
    list.forEachIndexed { index, item ->
        val stepCount = index + 1
        Text(
            text = "Step $stepCount" ,
            fontSize = 22.sp,
        )
        Text(
            text = item,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    bottom = 16.dp
                )
        )
    }
}

@Composable
fun CustomList(
    items: List<String>,
    useIndex: Boolean,
    itemFormatter: @Composable (Int, String) -> Unit
) {
    Column {
        if(useIndex){
            items.forEachIndexed { index, item ->
                itemFormatter(index, item)
            }
        } else {
            items.forEach { item ->
                itemFormatter(-1, item)
            }
        }
    }
}
@Composable
fun CustomBody( // note: the use of the ? means that the parameters can accept either their data type or null value
    text: String? = null,
    bulletItems: List<String>? = null,
    titleItems: List<String>? = null,
) {
    if(text != null){
        Text(
            text = text,
            fontSize = 16.sp,
        )
    }

    if(bulletItems != null){
        CustomList(
            items = bulletItems,
            useIndex = false,
            itemFormatter = { _, item ->
                Text(text = "• $item",
                    fontSize = 16.sp,
                    )
            })
    }

    if(titleItems != null){
        CustomList(
            items = titleItems,
            useIndex = true,
            itemFormatter = { index, item ->
                val displayVal = index + 1
                Text(text = "Step $displayVal",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                     )
                Text(text = item,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            bottom = 8.dp
                        )
                )
            })
    }
}

@Composable
fun CustomColumnWithTitle(
    title: String,
    bodyString: String? = null,
    bodyBulletList: List<String>? = null,
    bodyIndexList: List<String>? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Black)
            .padding(22.dp)
    ) {
        Text(
            text = title.uppercase(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        CustomBody(bodyString, bodyBulletList, bodyIndexList)

    }
}

@Preview
@Composable
fun PreviewRecipePage() {
    val recipeList = listOf(
        Recipe(
            title = "Pear And Rainbow",
            mainImage = R.drawable.pear,
            imageDescription = "3d rendering of a pear with a rainbow over it.",
            prepTime = 20,
            cookingTime = 65,
            servingSize = 4,
            difficulty = "Medium",
            recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous. Who knew how wonderful the thing could be. Well would you look at that, we are making a thing.",
            ingredients = listOf("Pear", "Rainbow", "Green paint"),
            steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
        ),
        Recipe(
            title = "Peach",
            mainImage = R.drawable.peach,
            imageDescription = "3d rendering of a close-up of a peach with googly eyes",
            prepTime = 10,
            cookingTime = 610,
            servingSize = 10,
            difficulty = "Easy",
            recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous.",
            ingredients = listOf("Peach", "Googly eyes", "Salmon paint"),
            steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
        )
    )
    RecipeCard(recipe = recipeList[0], modifier = Modifier)
}