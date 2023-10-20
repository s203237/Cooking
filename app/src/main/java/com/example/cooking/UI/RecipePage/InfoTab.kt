package com.example.cooking.UI.RecipePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R
import com.example.cooking.UI.SharedComponents.CustomHeading1
import com.example.cooking.UI.SharedComponents.CustomHeading2
import com.example.cooking.UI.SharedComponents.CustomTitle
import com.example.cooking.data.RecipeData
import com.example.cooking.model.Recipe
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
            DisplayRecipeInfo(recipe = recipe)
            CustomTitle(title = recipe.title, textAlign = TextAlign.Center)
            CustomHeading2(heading = recipe.author, textAlign = TextAlign.Center)
            CustomHeading1(heading = "description")
            Text(
                text = recipe.recipeDescription,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify
            )

            CustomHeading1(heading = "ingredients")
            BulletList(list = recipe.ingredients)
        }
    }
}
@Composable
private fun DisplayRecipeInfo(recipe: Recipe) {
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

@Preview
@Composable
fun PreviewInfoTab() {
    val recipeList = RecipeData().loadRecipes()
    InfoTab(recipe = recipeList[2])
}