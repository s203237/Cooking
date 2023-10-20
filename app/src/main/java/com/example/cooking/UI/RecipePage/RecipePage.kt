package com.example.cooking.UI.RecipePage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        ImageWithFavIcon(recipe = recipe)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 22.dp,
                    end = 22.dp,
                    bottom = 22.dp
                )
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
            .padding(
                start = 22.dp,
                end = 22.dp,
                bottom = 22.dp
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

@Composable
fun PrepTab(recipe: Recipe) {
    CustomHeading(heading = "steps")
    StepsList(list = recipe.steps)
}

@Composable
fun TabLayout(recipe: Recipe) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = Modifier.fillMaxWidth()
    ) {
        Tab(
            text = { CustomHeading(heading = "information") },
            selected = selectedTabIndex == 0,
            onClick = { selectedTabIndex = 0 }
        )
        Tab(
            text = { CustomHeading(heading = "preparation") },
            selected = selectedTabIndex == 1,
            onClick = { selectedTabIndex = 1 }
        )
    }
    when (selectedTabIndex) {
        0 -> InfoTab(recipe = recipe)
        1 -> PrepTab(recipe = recipe)
    }
}

@Preview
@Composable
fun PreviewRecipePage() {
    val recipeList = RecipeData().loadRecipes()
    RecipeCard(recipe = recipeList[0], modifier = Modifier)
}