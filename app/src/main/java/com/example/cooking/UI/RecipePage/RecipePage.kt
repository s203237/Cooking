package com.example.cooking.UI.RecipePage
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.model.Recipe
import com.example.cooking.data.RecipeData
import com.example.cooking.UI.SharedComponents.ImageWithFavIcon
import com.example.cooking.UI.SharedComponents.CustomTitle
import com.example.cooking.UI.SharedComponents.CustomHeading

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ImageWithFavIcon(recipe = recipe)

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TabLayout(recipe = recipe)
        }



    }
}


@Composable
fun DisplayRecipeInfo(recipe: Recipe) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        val prep = formatTime(recipe.prepTime)
        Text(
            text = "PREP: $prep",
            modifier = Modifier
                .fillMaxWidth(0.5f)
        )

        val cook = formatTime(recipe.cookingTime)
        Text(
            text = "COOK: $cook",
            )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        val diff = recipe.difficulty
        Text(
            text = "DIFFICULTY: $diff",
            modifier = Modifier
                .fillMaxWidth(0.5f)
        )

        val serv = recipe.servingSize
        Text(
            text = "SERVING SIZE: $serv",
        )
    }

    Row {
        Icon(Icons.Filled.Star, contentDescription = "Favourite Heart Outlined", tint = Color(0xFFF6CF00))
        Icon(Icons.Filled.Star, contentDescription = "Favourite Heart Outlined", tint = Color(0xFFF6CF00))
        Icon(Icons.Filled.Star, contentDescription = "Favourite Heart Outlined", tint = Color(0xFFF6CF00))
        Icon(Icons.Filled.Star, contentDescription = "Favourite Heart Outlined", tint = Color(0xFFF6CF00))
        Icon(Icons.Filled.Star, contentDescription = "Favourite Heart Outlined", tint = Color(0xFFF6CF00))

    }
}

private fun formatTime(minutes: Int): String {
    val formattedTime: String = if(minutes < 2) {
        "$minutes min"
    } else if (minutes < 60) {
        "$minutes mins"
    } else {
        val hrs = minutes / 60
        val min = minutes % 60
        val formattedMin = if (min < 10) "0$min" else min.toString()
        "$hrs hr $formattedMin min"
    }
    return formattedTime
}

@Composable
private fun BulletList(list: List<String>) {
    list.forEach { item ->
        Text(text =  "• $item",
            fontSize = 16.sp,
        )
    }
}

@Composable
private fun StepsList(list: List<String>) {
    list.forEachIndexed { index, item ->
        val stepCount = index + 1
        Text(
            text = "Step $stepCount" ,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
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
fun InfoTab(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.tab_right),
                contentDescription = "Right tab to view recipe information",
                modifier = Modifier
                    .fillMaxWidth(),
                alignment = Alignment.CenterEnd,
            )
            Image(
                painter = painterResource(id = R.drawable.tab_left),
                contentDescription = "Left tab to view recipe information",
                alignment = Alignment.CenterStart,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFF2ECE3))
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {
            CustomTitle(title = recipe.title)
            DisplayRecipeInfo(recipe = recipe)

            CustomHeading(heading = "description")
            Text(
                text = recipe.recipeDescription,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )

            CustomHeading(heading = "ingredients")
            BulletList(list = recipe.ingredients)
        }
    }
}

@Composable
fun PrepTab(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.tab_left),
                contentDescription = "Left tab to view recipe information",
                alignment = Alignment.CenterStart,
            )
            Image(
                painter = painterResource(id = R.drawable.tab_right),
                contentDescription = "Right tab to view recipe information",
                modifier = Modifier
                    .fillMaxWidth(),
                alignment = Alignment.CenterEnd,
            )

        }

        Box (
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color(0xFFF2ECE3)
                    )
                    .padding(16.dp)
            ) {
                CustomHeading(heading = "steps")
                StepsList(list = recipe.steps)
            }

            Image(
                painter = painterResource(id = R.drawable.tab_right_ext),
                contentDescription = "Extension of the right tab",
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }


    }
}

@Composable
fun TabLayout(recipe: Recipe) {
    var selectedTabIndex by remember { mutableStateOf(1) }
    Box (
        modifier = Modifier.fillMaxWidth()
    ){
        when (selectedTabIndex) {
            0 -> InfoTab(recipe = recipe)
            1 -> PrepTab(recipe = recipe)
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                .fillMaxWidth(0.5f)
                .clickable { selectedTabIndex = 0 },
                contentAlignment = Alignment.Center

            )
            {
                CustomHeading(heading = "information")
            }
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .clickable { selectedTabIndex = 1 },
                contentAlignment = Alignment.Center
            )
            {
                CustomHeading(heading = "preparation")
            }
        }

        /*TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color(0x00F2ECE3),

        ) {
            Tab(
                text = { CustomHeading(heading = "information") },
                selected = selectedTabIndex == 0,
                onClick = { selectedTabIndex = 0 },
            )
            Tab(
                text = { CustomHeading(heading = "preparation") },
                selected = selectedTabIndex == 1,
                onClick = { selectedTabIndex = 1 }
            )
        }*/
    }
}

@Preview
@Composable
fun PreviewRecipePage() {
    val recipeList = RecipeData().loadRecipes()
    RecipeCard(recipe = recipeList[2], modifier = Modifier)
}