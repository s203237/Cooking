package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.model.Recipe

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box() {
            Image(
                painter = painterResource(recipe.mainImage),
                contentDescription = recipe.contentDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = recipe.title,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(100.dp)
                    .border(2.dp, Color.Black),
            ) {
                Text(
                    text = "1 h 15",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .border(2.dp, Color.Black)
            ) {
                Text(
                    text = "4 servings",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.Center)
                )
            }

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(
                    0.dp, (-1).dp
                )
        ) {
            CustomColumnWithTitle(title = "ingredients", body = recipe.ingredients)
            CustomColumnWithTitle(title = "steps", body = recipe.steps)
        }


    }
}

@Composable
fun CustomColumnWithTitle(
    title: String,
    body: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Black)
    ) {
        Text(
            text = title.uppercase(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp),
        )

        Column {
            body.forEach { listItem ->
                Text(
                    text = "- $listItem",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(16.dp),
                )
            }
        }


        /*Text(
            text = body,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 0.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )*/
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
    bulletedItems: List<String>? = null,
    titledItems: List<String>? = null,
) {
    if(text != null){
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(16.dp),
        )
    }

    if(bulletedItems != null){
        CustomList(
            items = bulletedItems,
            useIndex = false,
            itemFormatter = { _, item ->
                Text(text = "• $item",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(8.dp)
                    )
            })
    }

    if(titledItems != null){
        CustomList(
            items = titledItems,
            useIndex = true,
            itemFormatter = { index, item ->
                Text(text = "Step $index\n $item",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(8.dp)
                )
            })
    }
}

@Composable
fun CustomListExample() {
    val items = listOf("Item 1", "Item 2", "Item 3")

    CustomList(items = items, useIndex = false, itemFormatter = { index, item ->
        Text(text = "• $item", fontSize = 16.sp, color = Color.Green)
    })
}



@Preview
@Composable
fun PreviewRecipePage() {
    val recipeList = listOf(
        Recipe(
            title = "Pear",
            mainImage = R.drawable.pear,
            contentDescription = "3d rendering of a pear with a rainbow over it.",
            ingredients = listOf("Pear", "Rainbow", "Green paint"),
            steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
        ),
        Recipe(
            title = "Peach",
            mainImage = R.drawable.pear,
            contentDescription = "3d rendering of a close-up of a peach with googly eyes",
            ingredients = listOf("Peach", "Googly eyes", "Salmon paint"),
            steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
        )
    )

    RecipeCard(recipe = recipeList[0], modifier = Modifier)
}