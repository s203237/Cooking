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
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
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
import kotlin.math.roundToInt

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
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        val prepTime =  formatTime(recipe.prepTime)
        val cookingTime = formatTime(recipe.cookingTime)

        InfoRowWithIcons(icon1 = Icons.Outlined.AccountCircle,infoType1 = "PREP", infoVal1 = prepTime, icon2 = Icons.Outlined.Info, infoType2 = "COOK", infoVal2 = cookingTime)

        val diff = recipe.difficulty
        val serv = recipe.servingSize.toString()
        InfoRowWithIcons(icon1 = Icons.Outlined.Info, infoType1 = "DIFFICULTY", infoVal1 = diff, icon2 = Icons.Outlined.Info, infoType2 = "SERVING SIZE", infoVal2 = serv)

        DisplayRating(4.45f);
    }
}
@Composable
private fun InfoRowWithIcons(icon1: ImageVector, infoType1: String, infoVal1: String, icon2: ImageVector? = null, infoType2: String? = null, infoVal2: String? = null) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ){
        Icon(
            icon1,
            contentDescription = "$infoType1 icon",
        )
        Text(
            text =  "$infoType1: $infoVal1",
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(start = 16.dp)
        )

        if(icon2 != null && infoType2 != null && infoVal2 != null) {
            Icon(
                icon2,
                contentDescription = "$infoType2 icon",
            )
            Text(
                text = "$infoType2: $infoVal2",
                modifier = Modifier.padding(start = 16.dp)
            )
        }
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
private fun DisplayRating(rating: Float) {
    val starCount = 5
    val filledStar: Painter = painterResource(id = R.drawable.baseline_star_24)
    val halfStar: Painter = painterResource(id = R.drawable.baseline_star_half_24)
    val borderStar: Painter = painterResource(id = R.drawable.baseline_star_border_24)
    val halfStarIndex = rating.roundToInt()

    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        var currentStar: Painter = filledStar
        for(i in 1..starCount) {
            if (i == halfStarIndex)
                currentStar = halfStar
            else if (i > halfStarIndex)
                currentStar = borderStar

            Icon(
                currentStar,
                contentDescription = "rating star"
            )
        }

    }
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