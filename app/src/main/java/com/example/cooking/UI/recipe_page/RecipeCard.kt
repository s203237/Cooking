package com.example.cooking.UI.recipe_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            Image(
                painter = painterResource(recipe.mainImage),
                contentDescription = recipe.imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .padding(top = 22.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topEnd = 13.dp,
                            bottomEnd = 13.dp
                        )
                    )
                    .background(color = Color(0xFFC1DAE2))
                    .fillMaxWidth(0.7f)

            ) {
                Text(
                    text = recipe.title,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(22.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(75.dp)
                    .border(2.dp, Color.Black)
                    .padding(16.dp),
            ) {
                Text(
                    text = "1 h 15",
                    fontSize = 22.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .border(2.dp, Color.Black)
                    .padding(16.dp),
            ) {
                Text(
                    text = "4 servings",
                    fontSize = 22.sp,
                    modifier = Modifier.align(Alignment.Center)
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
            CustomColumnWithTitle(title = "description", bodyString = recipe.recipeDescription)
            CustomColumnWithTitle(title = "ingredients", bodyBulletList = recipe.ingredients)
            CustomColumnWithTitle(title = "steps", bodyIndexList = recipe.steps)
        }


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
                        .padding(bottom = 16.dp)
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
            title = "Pear",
            mainImage = R.drawable.pear,
            imageDescription = "3d rendering of a pear with a rainbow over it.",
            recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous. Who knew how wonderful the thing could be. Well would you look at that, we are making a thing.",
            ingredients = listOf("Pear", "Rainbow", "Green paint"),
            steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
        ),
        Recipe(
            title = "Peach",
            mainImage = R.drawable.pear,
            imageDescription = "3d rendering of a close-up of a peach with googly eyes",
            recipeDescription = "This is a beautiful description of a thing I am making and it's going to be marvelous.",
            ingredients = listOf("Peach", "Googly eyes", "Salmon paint"),
            steps = listOf("Do the thing.", "Do the other thing.", "Do the final thing.")
        )
    )
    RecipeCard(recipe = recipeList[0], modifier = Modifier)
}